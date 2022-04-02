package util;

public class EmptyListException extends Exception
{
  public EmptyListException()
  {
    super();
  }

  public EmptyListException(String errormessage){
    super(errormessage);
  }
  public EmptyListException(String errormessage, Throwable err){
    super(errormessage, err);
  }
}
