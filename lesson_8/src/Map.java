import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class Map extends JPanel {
    public static final int MODE_H_V_A = 0;
    public static final int MODE_H_V_H = 1;

    private static final int DOT_EMPTY = 0;
    private static final int DOT_X = 1;
    private static final int DOT_O = 2;
    private static final int DOTS_PADDING = 5;
    private static Random rand = new Random();
    private static String MESSAGE = "";

    int[][] field;
    private int fieldSizeX;
    private int fieldSizeY;
    private int winLen;

    int cellHeight;
    int cellWidth;

    boolean isInitialized = false;

    Map() {
        setBackground(Color.LIGHT_GRAY);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                //super.mouseReleased(e);
                update(e);
            }
        });
    }

    void update(MouseEvent e) {
        int cellX = e.getX() / cellWidth;
        int cellY = e.getY() / cellHeight;

        field[cellX][cellY] = DOT_X;
        repaint();
        if (checkWin(DOT_X)) {
            MESSAGE = "Победил человек";
            return;
        }
        if (isMapFull()) {
            MESSAGE = "Ничья";
            return;
        }
        aiTurn();
        repaint();
        if (checkWin(DOT_O)) {
            MESSAGE = "Победил компьютер";
            return;
        }
        if (isMapFull()) {
            MESSAGE = "Ничья";
            return;
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        render(g);
    }

    void startNewGame(int mode, int fieldSizeX, int fieldSizeY, int winLen) {
//        setBackground(Color.LIGHT_GRAY);
        MESSAGE = "";
        this.fieldSizeX = fieldSizeX;
        this.fieldSizeY = fieldSizeY;
        this.winLen = winLen;
        field = new int[fieldSizeY][fieldSizeX];
        isInitialized = true;
        repaint();
    }

    void render(Graphics g) {
        if (!isInitialized) return;

        int panelWidth = getWidth();
        int panelHeight = getHeight();

        cellWidth = panelWidth / fieldSizeX;
        cellHeight = panelHeight / fieldSizeY;

        // рисуем горизонтальные полоски
        for (int i = 0; i < fieldSizeY; i++) {
            int y = i * cellHeight;
            g.drawLine(0, y, panelWidth, y);
        }

        // рисуем вертикальные полоски
        for (int i = 0; i < this.fieldSizeX; i++) {
            int x = i * cellWidth;
            g.drawLine(x, 0, x, panelHeight);
        }

        //проходим по всем полям карты
        for (int i = 0; i < this.fieldSizeX; i++) {
            for (int j = 0; j < this.fieldSizeX; j++) {
                int x1 = i * cellWidth + DOTS_PADDING + 10;
                int y1 = j * cellHeight + DOTS_PADDING + 10;
                int x2 = x1 + cellWidth - DOTS_PADDING * 2 - 10;
                int y2 = y1 + cellHeight - DOTS_PADDING * 2 - 10;
                if (field[i][j] == DOT_X) {
                    g.drawLine(x1, y1, x2, y2);
                    g.drawLine(x1, y2, x2, y1);
                }
                if (field[i][j] == DOT_O) {
                    g.drawOval(x1 - 10, y1 - 10, cellWidth - DOTS_PADDING * 2, cellHeight - DOTS_PADDING * 2);
                }
            }
        }
        showMessage(g);
    }

    private boolean isMapFull() {
        for (int i = 0; i < this.fieldSizeX; i++) {
            for (int j = 0; j < this.fieldSizeY; j++) {
                if (field[i][j] == DOT_EMPTY) return false;
            }
        }
        return true;
    }

    private boolean checkWin(int symb) {
        for (int i = 0; i < this.fieldSizeX; i++) {
            for (int j = 0; j < this.fieldSizeY; j++) {
                if ((field[i][j] == symb && this.winLen <= this.fieldSizeX - j && right(i, j, this.winLen - 1, symb)) ||
                        (field[i][j] == symb && this.winLen <= this.fieldSizeX - i && down(i, j, this.winLen - 1, symb)) ||
                        (field[i][j] == symb && this.winLen <= this.fieldSizeX - j && this.winLen <= this.fieldSizeX - i && diag(i, j, this.winLen - 1, symb)) ||
                        (field[i][j] == symb && this.winLen <= this.fieldSizeX - j && this.winLen <= i + 1 && diagUp(i, j, this.winLen - 1, symb))) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean right(int i, int j, int n, int symb) {
        int qnt = 0;
        for (int jl = j + 1; jl <= j + n; jl++) {
            if (field[i][jl] == symb) qnt++;
        }
        return qnt == n;
    }

    private boolean left(int i, int j, int n, int symb) {
        int qnt = 0;
        for (int jl = j - 1; jl >= j - n; jl--) {
            if (field[i][jl] == symb) qnt++;
        }
        return qnt == n;
    }

    private boolean up(int i, int j, int n, int symb) {
        int qnt = 0;
        for (int il = i - 1; il >= i - n; il--) {
            if (field[il][j] == symb) qnt++;
        }
        return qnt == n;
    }

    private boolean down(int i, int j, int n, int symb) {
        int qnt = 0;
        for (int il = i + 1; il <= i + n; il++) {
            if (field[il][j] == symb) qnt++;
        }
        return qnt == n;
    }

    private boolean diag(int i, int j, int n, int symb) {
        int qnt = 0;
        for (int il = i + 1, jl = j + 1; il <= i + n; il++, jl++) {
            if (field[il][jl] == symb) qnt++;
        }
        return qnt == n;
    }

    private boolean diagUp(int i, int j, int n, int symb) {
        int qnt = 0;
        for (int il = i - 1, jl = j + 1; jl <= j + n; il--, jl++) {
            if (field[il][jl] == symb) qnt++;
        }
        return qnt == n;
    }

    private void aiTurn() {
        int x, y;
        do {
            x = aiNextX();
            y = aiNextY();
        } while (!isCellValid(x, y));
        field[y][x] = DOT_O;
    }

    private boolean isCellValid(int x, int y) {
        if (x >= 0 && x < this.fieldSizeX && y >= 0 && y < this.fieldSizeY && field[y][x] == DOT_EMPTY) return true;
        return false;
    }

    private int aiNextX() {
        int symb = DOT_X;
        for (int i = 0; i < this.fieldSizeX; i++) {
            for (int j = 0; j < this.fieldSizeY; j++) {
                if ((field[i][j] == DOT_EMPTY && this.winLen <= this.fieldSizeX - j && right(i, j, this.winLen - 1, symb)) ||
                        (field[i][j] == DOT_EMPTY && this.winLen <= j + 1 && left(i, j, this.winLen - 1, symb)) ||
                        (field[i][j] == DOT_EMPTY && this.winLen <= i + 1 && up(i, j, this.winLen - 1, symb)) ||
                        (field[i][j] == DOT_EMPTY && this.winLen <= this.fieldSizeX - i && down(i, j, this.winLen - 1, symb)) ||
                        (field[i][j] == DOT_EMPTY && this.winLen <= this.fieldSizeX - j && this.winLen <= this.fieldSizeX - i && diag(i, j, this.winLen - 1, symb)) ||
                        (field[i][j] == DOT_EMPTY && this.winLen <= this.fieldSizeX - j && this.winLen <= i + 1 && diagUp(i, j, this.winLen - 1, symb))) {
                    return j;
                }
            }
        }
        return rand.nextInt(this.fieldSizeX);
    }

    private int aiNextY() {
        int symb = DOT_X;
        for (int i = 0; i < this.fieldSizeX; i++) {
            for (int j = 0; j < this.fieldSizeY; j++) {
                if ((field[i][j] == DOT_EMPTY && this.winLen <= this.fieldSizeX - j && right(i, j, this.winLen - 1, symb)) ||
                        (field[i][j] == DOT_EMPTY && this.winLen <= j + 1 && left(i, j, this.winLen - 1, symb)) ||
                        (field[i][j] == DOT_EMPTY && this.winLen <= i + 1 && up(i, j, this.winLen - 1, symb)) ||
                        (field[i][j] == DOT_EMPTY && this.winLen <= this.fieldSizeX - i && down(i, j, this.winLen - 1, symb)) ||
                        (field[i][j] == DOT_EMPTY && this.winLen <= this.fieldSizeX - j && this.winLen <= this.fieldSizeX - i && diag(i, j, this.winLen - 1, symb)) ||
                        (field[i][j] == DOT_EMPTY && this.winLen <= this.fieldSizeX - j && this.winLen <= i + 1 && diagUp(i, j, this.winLen - 1, symb))) {
                    return i;
                }
            }
        }
        return rand.nextInt(this.fieldSizeX);
    }

    private void showMessage(Graphics g) {
        g.setColor(Color.BLUE);
        g.setFont(new Font("", Font.BOLD, 30));
        g.drawString(MESSAGE, 50, 250);
    }
}