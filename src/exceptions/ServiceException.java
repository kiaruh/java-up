package exceptions;

@SuppressWarnings("serial")
public class ServiceException extends Exception{

		public ServiceException(){			
		}
		
		public ServiceException(String msg){
			super(msg);
		}
		public ServiceException(String msg, DAOException e) {
			super(msg, e);
		}
}
