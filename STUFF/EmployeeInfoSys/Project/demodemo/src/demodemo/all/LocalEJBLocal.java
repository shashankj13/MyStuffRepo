package demodemo.all;

import java.util.List;

import javax.ejb.Local;

@Local
public interface LocalEJBLocal {
	
	public List<String> getSkillList();
	public List<String> getSkillEfficiencyList();

}
