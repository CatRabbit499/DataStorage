package dataStorage;

public class CuttlefishException extends Exception{
	private static final long serialVersionUID = 6209757130510347929L;
	public CuttlefishException(){ super();}
	public CuttlefishException(String message){super(message);}
	public CuttlefishException(String message, Throwable cause){super(message, cause);}
	public CuttlefishException(Throwable cause){super(cause);}
}
