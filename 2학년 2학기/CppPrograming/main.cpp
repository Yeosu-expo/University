#include <iostream>
#include <cstdlib>
#include <string>
#include <windows.h>
#include <chrono>
using namespace std;

class GameObject    
{
public:
    short x;
    short y;
    char shape;
};
 
class Player : public GameObject 
{ 
public:  
    Player(char shape2,  short y1 = -1, short y2 = -1);
    void move();
};

Player::Player(char shape2, short x2, short y2)
{
    this->x = x2;
    this->y = y2;
    this->shape = shape2;
}

class Apple : public GameObject{
public:
    bool isAlive;
};

class IntObject: public GameObject{
public:
    string text;
    int value;
};

class GameManager
{
public:
    void Run();    
};

void PrintObject(GameObject* gameObject, bool isShape, bool isIntObject= false)   
{
    HANDLE hOut = GetStdHandle(STD_OUTPUT_HANDLE);
    if(gameObject->x == -1)
        gameObject->x = rand() % 79;
    if(gameObject->y == -1)
        gameObject->y = rand() % 23 + 1;

    COORD position = { gameObject->x, gameObject->y };

    SetConsoleCursorPosition(hOut, position);

    if(isShape)
        cout << gameObject->shape;
    else{
        if(isIntObject){
            cout << "Score: " << ((IntObject *)gameObject)->value;
        }
        else
            cout << " ";
    }
}

void GameManager::Run()
{
    chrono::steady_clock::time_point start = chrono::steady_clock::now();
    chrono::steady_clock::time_point end;
    IntObject score;
    score.x = 0;
    score.y = 0;
    score.text = "Score: ";
    score.value = 0;
    Player player('@', 5, 5);
    int max_apples = 3;
    Apple* apples = new Apple[max_apples];

    for(int i=0;i<max_apples;i++){
        apples[i].x =-1;
        apples[i].y =-1;
        apples[i].shape = (char)('1'+i);
        apples[i].isAlive = true;
    }
    

    INPUT_RECORD buf;
    DWORD n;
    HANDLE hIn = GetStdHandle(STD_INPUT_HANDLE);
    HANDLE hOut = GetStdHandle(STD_OUTPUT_HANDLE);

    for(;;)
    {        
        //출력부
        PrintObject(&score, false, true);
        PrintObject(&player, true);
        bool check = false;
        for(int i=0;i<max_apples;i++){
            if(apples[i].isAlive){
                PrintObject(&apples[i], true);
                check = true;
            }
        }

        if(!check){
            end = chrono::steady_clock::now();
            cout << chrono::duration_cast<chrono::milliseconds>(end - start).count()/1000 << "ms elapsed";
            return;
        }
        //키보드 입력 체크 및 처리
        ReadConsoleInput(hIn, &buf, 1, &n);
        if(buf.EventType == KEY_EVENT
             && ((KEY_EVENT_RECORD&)buf.Event).bKeyDown)
        {
            PrintObject(&player, false);
            switch(buf.Event.KeyEvent.wVirtualKeyCode)
            {
                case VK_UP:
                    player.y--;
                    break;
                case VK_DOWN:
                    player.y++;
                    break;
                case VK_LEFT:
                    player.x--;
                    break;
                case VK_RIGHT:
                    player.x++;
                    break;
            }
            for(int i=0;i<max_apples;i++){
                if(apples[i].isAlive){
                    if(player.x == apples[i].x && player.y == apples[i].y){
                        apples[i].isAlive = false;
                        score.value++;
                        break;
                    }
                }
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