package kmitl.cs.entp.thanapat.sessionbeandemo.sessionbeans;

import java.io.Serial;
import java.io.Serializable;

import jakarta.ejb.LocalBean;
import jakarta.ejb.Singleton;
import jakarta.ejb.Stateful;
import jakarta.ejb.Stateless;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.context.SessionScoped;

/**
 * Session Bean implementation class CounterBean
 */
@Stateful
//@Singleton
//@Stateless
@LocalBean
//@SessionScoped
//@RequestScoped
@ApplicationScoped
public class CounterBean implements Serializable {

    /**
	 * 
	 */
	@Serial
	private static final long serialVersionUID = 1L;
	/**
     * Default constructor. 
     */
	private int counter = 0;
    public CounterBean() {
        // TODO Auto-generated constructor stub
    }
    public int increment() {
    	return ++counter;
    }

}
