package theExceptions;

@SuppressWarnings("serial")
public class PolicyNotFoundException extends Exception{
	public PolicyNotFoundException(int policyID) {
		super("Policy not found with ID: "+policyID);
	}
}
