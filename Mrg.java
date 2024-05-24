import java.util.Scanner;

class Game{
    static char board[][];
    Game(){
        board = new char[3][3];
        initial();
    }
    void initial(){
        for (int i =0; i< 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }
    boolean rowWin(){
        for (int i =0; i<3; i++){
            if (board[i][0] !=' ' && board[i][0] == board[i][1] && board[i][1]== board[i][2]){
                return true;
            }
        }
        return false;
    }
    boolean colWin(){
        for (int i=0;i<3;i++){
            if (board[0][i] !=' ' && board[0][i] == board[1][i] && board[1][i] == board[2][i]){
                return true;
            }
        }
        return false;
    }



    static void placeMarker(int row, int col, char mark){
        board[row][col] = mark;

    }

    void display(){
        System.out.println("-------------");
        for (int i =0; i< 3; i++){
            System.out.print("| ");
            for (int j =0; j< 3; j++){
                System.out.print(board[i][j]+" | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }
}
class HumanPlayer{
    String name;
    char mark;
    HumanPlayer(String name, char mark){
        this.name = name;
        this.mark = mark;
    }
    void makeMove(){
        Scanner scan = new Scanner(System.in);
        int row,col;
        do {
            System.out.println("Enter the row");
            row = scan.nextInt();
            System.out.println("Enter col");
            col = scan.nextInt();

        }while (!validMove(row,col));
        Game.placeMarker(row,col,mark);

    }

    boolean validMove(int row, int col){
        if (Game.board[row][col] == ' '){
            return true;
        }
        return false;
    }
}

class Mrg{
    public static void main(String[] args) {
        Game g = new Game();
        HumanPlayer p1 = new HumanPlayer("Arjun",'x');
        HumanPlayer p2 = new HumanPlayer("Manoj",'o');
        HumanPlayer cp;

        cp = p1;
        while (true) {
            System.out.println(cp.name + " trun ");
            cp.makeMove();
            g.display();
            if (g.rowWin() || g.colWin()) {


                System.out.println(cp.name + " has won ");
                break;
            }
            if (cp == p1) {
                cp = p2;
            } else {
                cp = p1;
            }
        }

    }
}