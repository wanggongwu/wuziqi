package game_wuziqi;

public interface Gobang {
    public static final  Integer SIZE =40;//设置格子大小为40
    public static final Integer X=20,Y=20;//设置棋盘右上角位置
    public static final Integer COLOUM=15;//设置行数
    public static final Integer ROW=15;//设置列数
    public static final Integer [] []ARRAY=new Integer[COLOUM][ROW ];//记录棋子位置的数组
    public static final Integer [] [] WEIGHTAEEAY=new Integer[COLOUM][ROW];//记录每个棋盘位置的权值
    public static final boolean FLAG []=new boolean[2];//记录选择的模式
}
