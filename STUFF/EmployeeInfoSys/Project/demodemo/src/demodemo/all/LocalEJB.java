package demodemo.all;

import java.util.List;

import javax.ejb.Stateless;

/**
 * Session Bean implementation class LocalEJB
 */
@Stateless
public class LocalEJB implements LocalEJBLocal {
	
	Dao dao1 = new Dao();
	
    public LocalEJB() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public List<String> getSkillList() {
		List<String> list1 = dao1.fetchSkill();
		return list1;
	}

	@Override
	public List<String> getSkillEfficiencyList() {
		List<String> list2 = dao1.fetchSkillEfficiency();
		return list2;
	}

}
