package boardgame;

public class BoardExeption extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public BoardExeption(String msg) {
		super(msg);
	}
}
