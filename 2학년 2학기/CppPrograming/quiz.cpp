#include <iostream>
#include <cstdlib>
#include <string>
#include <windows.h>
#include <chrono>
using namespace std;

class GameObject
{
public:
    int x;
    int y;
    char shape;
    GameObject() {}
    GameObject(char shape, int x, int y)
    {
        this->shape = shape;
        this->x = x;
        this->y = y;
    }
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

class IntObject : public GameObject
{
public:
    string text;
    int value;
    IntObject(){}
    IntObject(int x, int y, string text, int value) : GameObject(' ', x, y)
    {
        this->text = text;
        this->value = value;
    }
};

class GameManager
{
public:
    void Run();
};

void PrintObject(GameObject *gameObject, bool isShape, bool isIntObject = false)
{
    HANDLE hOut = GetStdHandle(STD_OUTPUT_HANDLE);
    if (gameObject->x == -1)
        gameObject->x = rand() % 79;
    if (gameObject->y == -1)
        gameObject->y = rand() % 23 + 1;

    COORD position = {(short)(gameObject->x), (short)(gameObject->y)};

    SetConsoleCursorPosition(hOut, position);

    if (isShape)
        cout << gameObject->shape;
    else
    {
        if (isIntObject)
        {
            if(((IntObject *)gameObject)->value != 0)
                cout << ((IntObject *)gameObject)->text << ((IntObject *)gameObject)->value;
            else
                cout << ((IntObject *)gameObject)->text;
        }
        else
            cout << " ";
    }
}

void GameManager::Run()
{
    chrono::steady_clock::time_point start = chrono::steady_clock::now();
    chrono::steady_clock::time_point end;

    INPUT_RECORD buf;
    DWORD n;
    HANDLE hIn = GetStdHandle(STD_INPUT_HANDLE);
    HANDLE hOut = GetStdHandle(STD_OUTPUT_HANDLE);

    IntObject stage(0,0,"STAGE: ", 1);
    IntObject *where = new IntObject[20];
    int isOver = 0;
    IntObject clearPage(0,0,"                    \n                                \n                            ", 0);


    for(;;){
        //PrintObject(&clearPage, false, true);
        if(isOver == 1){
            break;
        }
        for(int i=0;i<stage.value+2;i++){
            int randNum = rand()%4;
            string str;
            switch(randNum){
                case 0:
                str = "UP ";
                break;
                case 1:
                str = "DOWN ";
                break;
                case 2:
                str = "RIGHT ";
                break;
                case 3:
                str = "LEFT ";
                break;
            }
            if(i==0){
                where[i].x = 0;
            }
            else{
                where[i].x = where[i-1].x + where[i-1].text.length();
            }
            where[i].y = 1;
            where[i].text = str;
            where[i].value = 0;
        }

        PrintObject(&stage, false, true);
        for(int i=0;i<stage.value+2;i++){
            PrintObject(&where[i], false, true);
        }

        int count = 0;
        int loc = 0;
        string inputs = "INPUT\n";
        IntObject inputsObj(0, 1, inputs, 0);
        IntObject timeLimit(0, 2, "Time: ", 0);
        for(;;){
            end = chrono::steady_clock::now();
            auto elapsedTime = chrono::duration_cast<chrono::seconds>(end - start).count();
            timeLimit.value = static_cast<int>(elapsedTime);

            PrintObject(&timeLimit, false, true);
            if (chrono::duration_cast<chrono::seconds>(end - start).count() > 3)
                break;
        }
        PrintObject(&clearPage, false, true);
        string inputStrs;
        IntObject strs(0,2,"",0);
        for (;;)
        {
            // 출력부
            strs.text = inputStrs;
            PrintObject(&strs, false, true);
            PrintObject(&inputsObj, false, true);
            if(loc == stage.value+2){
                if(count != stage.value+2){
                    cout << "Game Over!";
                    isOver = 1;
                }
                else{
                    stage.value++;
                }
                PrintObject(&clearPage, false, true);
                break;
            }

            // 키보드 입력 체크 및 처리
            ReadConsoleInput(hIn, &buf, 1, &n);
            if (buf.EventType == KEY_EVENT && ((KEY_EVENT_RECORD &)buf.Event).bKeyDown)
            {
                switch (buf.Event.KeyEvent.wVirtualKeyCode)
                {
                case VK_UP:
                    inputs += "UP ";
                    inputStrs += "UP ";
                    if(where[loc].text == "UP ")
                        count++;
                    break;
                case VK_DOWN:
                    inputs += "DOWN ";
                    inputStrs += "DOWN ";
                    if(where[loc].text == "DOWN ")
                        count++;
                    break;
                case VK_LEFT:
                    inputs += "LEFT ";
                    inputStrs += "LEFT ";
                    if(where[loc].text == "LEFT ")
                        count++;
                    break;
                case VK_RIGHT:
                    inputs += "RIGHT ";
                    inputStrs += "RIGHT ";
                    if(where[loc].text == "RIGHT ")
                        count++;
                    break;
                }
                loc++;
            }
        }
    }
}

int main(){
    GameManager gameManager;
    gameManager.Run();

    system("pause");

    return 0;
}