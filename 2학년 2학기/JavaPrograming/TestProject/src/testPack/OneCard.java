package testPack;

public class OneCard {
    String shape;
    int num;

    public OneCard(){
        int shape = (int)(Math.random()*4);
        int num = (int)(Math.random()*12)+1;

        this.shape = strShape(shape);
        this.num = num;
    }

    public OneCard(String shape){
        this.shape = shape;
        this.num = (int)(Math.random()*12)+1;
    }

    public OneCard(int num){
        int shape = (int)(Math.random()*4);

        this.shape = strShape(shape);
        this.num = num;
    }

    public OneCard(String shape, int num){
        this.shape = shape;
        this.num = num;
    }

    public void getCard(){
        int shape = (int)(Math.random()*4);
        int num = (int)(Math.random()*12)+1;

        this.shape = strShape(shape);
        this.num = num;
    }
    public boolean isOverlap(OneCard rival){
        if(this.num==rival.num&&this.shape==rival.shape)
            return true;
        else
            return false;
    }

    public boolean isOverlapInArr(OneCard[] arr, OneCard newCard, int size) {
        for(int i=0;i<size;i++){
            boolean res = newCard.isOverlap(arr[i]);
            if(res)
                return true;
        }
        return false;
    }

    public void printCard(int num){
        System.out.println("Player"+num+": "+this.shape+", "+strNum(this.num));
    }

    public void compete(OneCard rival){
        this.printCard(1);
        rival.printCard(2);

        int res = whoisBig(this, rival);
        if(res==0){
            System.out.println("Player1 won!!");
        }
        else {
            System.out.println("Player2 won!!");
        }
    }
    public int whoisBig(OneCard c1, OneCard c2){
        if(c1.num ==  1&&c2.num != 1){
            return 0;
        }
        else if(c2.num == 1&&c1.num != 1){
            return 1;
        }

        if(c1.num > c2.num){
            return 0;
        }
        else if (c1.num == c2.num){
            if(intShape(c1.shape) < intShape(c2.shape)){
                return 0;
            }
            else {
                return 1;
            }
        }
        else {
            return 1;
        }
    }
    public String strShape(int shape){
        switch (shape) {
            case 0 :
                return "스페이드";
            case 1 :
                return "다이아몬드";
            case 2 :
                return "하트";
            case 3 :
                return "클로버";
        }
        return null;
    }
    public int intShape(String shape){
        switch (shape) {
            case "스페이드" :
                return 0;
            case "다이아몬드" :
                return 1;
            case "하트" :
                return 2;
            case "클로버" :
                return 3;
            default :
                return -1;
        }
    }
    public String strNum(int num){
        switch (num) {
            case 1 :
                return "ACE";
            case 11 :
                return "J";
            case 12 :
                return "Q";
            case 13 :
                return "K";
            default :
                return Integer.toString(num);
        }
    }
    public OneCard[] sorting(OneCard[] arr){
        OneCard tmpArr[] = new OneCard[10];

        int isChecked[] = new int[10];
        int maxx;
        for(int i=0;i<10;i++) {
            maxx = 0;
            for(int j=1;j<10;j++){
                if(isChecked[maxx]==1){
                    maxx++;
                    continue;
                }
                if(isChecked[j]==1){
                    continue;
                }
                int res = whoisBig(arr[maxx], arr[j]);
                
                if(res==1)
                    maxx=j;
            }
            isChecked[maxx]=1;
            tmpArr[i]=arr[maxx];
        }

        return tmpArr;
    }
}

class UNO extends OneCard {
    
}
