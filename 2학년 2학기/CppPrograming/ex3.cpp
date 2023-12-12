#include <iostream>
#include <cstdlib>
#include <string>
#include <chrono>
#include <windows.h>
#include <iomanip>
#include <fstream>

using namespace std;
using namespace chrono;

class GameObject
{
public:
    int x;
    int y;
    char shape;
};

class Player : public GameObject
{
public:
    Player(char shape2, int x2 = -1, int y2 = -1);
    void move();
};

Player::Player(char shape2, int x2, int y2)
{
    this->x = x2;
    this->y = y2;
    this->shape = shape2;
}

class Enemy : public GameObject
{
public:
    bool isAlive;
    int moveCount;
    bool isLeft;
};

class Bullet : public GameObject
{
public:
    bool isAlive;
};

class IntObject : public GameObject
{
public:
    string text;
    int value;
};

class GameManager
{
public:
    void Run();
};

void PrintObject(GameObject *gameObject,
                 bool isShape, bool isIntObject = false, int length = -1)
{
    HANDLE hOut = GetStdHandle(STD_OUTPUT_HANDLE);

    if (gameObject->x == -1)
        gameObject->x = rand() % 79;

    if (gameObject->y == -1)
        gameObject->y = rand() % 23 + 1;

    COORD position = {(short)gameObject->x, (short)gameObject->y};
    SetConsoleCursorPosition(hOut, position);

    if (isShape)
        std::cout << gameObject->shape;
    else
    {
        if (isIntObject)
        {
            cout << ((IntObject *)gameObject)->text;

            if (length != -1)
                cout << setw(length) << left;

            cout << ((IntObject *)gameObject)->value;
        }
        else
        {
            std::cout << " ";
        }
    }
}

void GameManager::Run()
{
    ifstream fin("./score.txt");
    if (!fin)
    {
        cout << "failed open" << endl;
        return;
    }
    int s;
    fin >> s;
    fin.close();

    int enemyMoveCount = 10;

    IntObject stage;

    stage.text = "Stage : ";
    stage.x = 50;
    stage.y = 0;

    stage.value = 1;

    IntObject score;

    score.text = "Score : ";
    score.x = 0;
    score.y = 0;

    score.value = 0;

    int max_enemies = 1;

    IntObject fileSocre;
    fileSocre.text = "FScore: ";
    fileSocre.x = 20;
    fileSocre.y = 0;

    fileSocre.value = s;

    for (;;)
    {
        int max_time = 10;
        steady_clock::time_point start = steady_clock::now();
        steady_clock::time_point end;

        IntObject time;

        time.text = "Time : ";
        time.x = 25;
        time.y = 0;

        time.value = max_time;

        Player player('A', 5, 23);
        Bullet bullet;
        bullet.shape = '|';
        bullet.isAlive = false;

        Enemy *enemies = new Enemy[max_enemies];

        for (int i = 0; i < max_enemies; i++)
        {
            enemies[i].isAlive = true;
            enemies[i].x = -1;
            enemies[i].y = 2;
            enemies[i].moveCount = enemyMoveCount;
            enemies[i].isLeft = true;

            enemies[i].shape = '*';
        }

        INPUT_RECORD buf;
        DWORD n;
        HANDLE hIn = GetStdHandle(STD_INPUT_HANDLE);
        HANDLE hOut = GetStdHandle(STD_OUTPUT_HANDLE);

        for (;;)
        {
            // 출력부
            PrintObject(&score, false, true);
            int remain = max_time - duration_cast<seconds>(steady_clock::now() - start).count();

            if (remain < 0)
            {
                cout << "Time over!!";
                return;
            }

            time.value = remain;
            PrintObject(&time, false, true, 2);
            PrintObject(&stage, false, true);

            PrintObject(&player, true);

            for (int i = 0; i < max_enemies; i++)
            {
                if (enemies[i].isAlive)
                    PrintObject(&enemies[i], true);
            }

            // 키보드 입력 체크 및 처리
            if (!WaitForSingleObject(hIn, 1))
            {
                ReadConsoleInput(hIn, &buf, 1, &n);
                if (buf.EventType == KEY_EVENT && ((KEY_EVENT_RECORD &)buf.Event).bKeyDown)
                {
                    PrintObject(&player, false);

                    switch (buf.Event.KeyEvent.wVirtualKeyCode)
                    {
                    case VK_LEFT:
                        if (player.x > 0)
                            player.x--;
                        break;

                    case VK_RIGHT:
                        if (player.x < 79)
                            player.x++;
                        break;

                    case VK_SPACE:
                        bullet.isAlive = true;
                        bullet.x = player.x;
                        bullet.y = player.y - 1;
                        break;
                    }
                }
            }

            if (bullet.isAlive)
            {
                PrintObject(&bullet, false);
                if (bullet.y > 2)
                {
                    bullet.y--;
                    PrintObject(&bullet, true);

                    // 총알과 적이 충돌하였는가?
                    for (int i = 0; i < max_enemies; i++)
                    {
                        if (enemies[i].isAlive)
                        {
                            if (bullet.x == enemies[i].x && bullet.y == enemies[i].y)
                            {
                                score.value += 10;
                                enemies[i].isAlive = false;
                            }
                        }
                    }
                }
                else
                    bullet.isAlive = false;
            }

            // 모든 적이 죽었는 지 체크
            int deadEnemies = 0;
            for (int i = 0; i < max_enemies; i++)
            {
                if (!enemies[i].isAlive)
                {
                    deadEnemies++;
                }
                else
                {
                    PrintObject(&enemies[i], false);

                    if (enemies[i].isLeft)
                    {
                        if (enemies[i].x > 1)
                        {
                            enemies[i].moveCount--;
                            if (enemies[i].moveCount == 0)
                            {
                                enemies[i].x--;
                                enemies[i].moveCount = enemyMoveCount;
                            }
                        }
                        else
                            enemies[i].isLeft = false;
                    }
                    else
                    {
                        if (enemies[i].x < 78)
                        {
                            enemies[i].moveCount--;
                            if (enemies[i].moveCount == 0)
                            {
                                enemies[i].x++;
                                enemies[i].moveCount = enemyMoveCount;
                            }
                        }
                        else
                            enemies[i].isLeft = true;
                    }
                }
            }

            if (deadEnemies == max_enemies)
            {
                PrintObject(&score, false, true);
                break;
            }
        }

        // 메모리 정리
        delete[] enemies;

        stage.value++;

        max_enemies++;
        system("cls");
    }
    ofstream fout("./score.txt");
    if (!fout)
    {
        cout << "failed open2" << endl;
        return;
    }
    if (score.value > s)
    {
        fout << score.value;
    }
}

int main()
{

    GameManager gameManager;
    gameManager.Run();

    system("pause");
}
