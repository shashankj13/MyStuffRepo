package com.yash.training.tmp.bean;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import com.yash.training.tmp.domain.ManagerMenu;
import com.yash.training.tmp.domain.TraineeMenu;
import com.yash.training.tmp.domain.TrainerMenu;
import com.yash.training.tmp.domain.User;
import com.yash.training.tmp.service.UserServiceLocal;

/**
 * 
 * @author honey.merwani
 *
 */

@ManagedBean
@SessionScoped
public class UserBean {

	@Inject
	User user;

	@Inject
	ManagerMenu managerMenu;

	@Inject
	TrainerMenu trainerMenu;

	@Inject
	TraineeMenu traineeMenu;

	private String name;
	private String contact;
	private String email;
	private int designation;
	private String userName;
	private String password;
	private int user_id;

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	/*List<String> managerMenuList = new ArrayList<>();
	List<String> trainerMenuList = new ArrayList<>();
	List<String> traineeMenuList = new ArrayList<>();*/
	List<String> populateList = new ArrayList<>();
	public ManagerMenu getManagerMenu() {
		return managerMenu;
	}

	public void setManagerMenu(ManagerMenu managerMenu) {
		this.managerMenu = managerMenu;
	}

	public TrainerMenu getTrainerMenu() {
		return trainerMenu;
	}

	public void setTrainerMenu(TrainerMenu trainerMenu) {
		this.trainerMenu = trainerMenu;
	}

	public TraineeMenu getTraineeMenu() {
		return traineeMenu;
	}

	public void setTraineeMenu(TraineeMenu traineeMenu) {
		this.traineeMenu = traineeMenu;
	}

	

	

	public List<String> getPopulateList() {
		return populateList;
	}

	public void setPopulateList(List<String> populateList) {
		this.populateList = populateList;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getDesignation() {
		return designation;
	}

	public void setDesignation(int designation) {
		this.designation = designation;
	}

	public String getUserName() {

		/*ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
		HttpServletRequest request = (HttpServletRequest) context.getRequest();
		Cookie cookies[] = request.getCookies();
		if (cookies != null && cookies.length > 0) {
			System.out.println("COOKIES LENGTH------------------ " + cookies.length);
			for (int i = 0; i < cookies.length; i++) {
				if (cookies[i].getName().equals("cookieUsername")) {
					this.userName = cookies[i].getValue();
					break;
				}
				if (cookies[i].getName().equals("cookiePass")) {
					this.password = cookies[i].getValue();
					break;
				}
			}
		}*/

		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@EJB
	UserServiceLocal userServiceLocal;

	public String userAuthenticate() throws Exception {
		System.out.println(user);
		String message = userServiceLocal.userAuthenticate(userName, password);
		if (message.equalsIgnoreCase("success")) {
			
			User user = userServiceLocal.getUserName(userName, password);
			setName(user.getName());
			HttpSession httpSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext()
					.getSession(true);
			httpSession.setAttribute("userId", user.getUserid());
			
			user_id =  user.getUserid();
			System.out.println("INSIDE USER BEAN ---------------user_id --- BEAN VARIABLE INITIALIZED " + user_id);

			int d_id = user.getDesignation_id();
			if (d_id == 1) {
				populateList.add(managerMenu.getAddTrainingPlan());
				populateList.add(managerMenu.getRemoveTrainer());
				populateList.add(managerMenu.getTestResult());
				populateList.add(managerMenu.getSeeAllTrainers());

				System.out.println("this is manager");
			}

			if (d_id == 2) {

				populateList.add(trainerMenu.getSetPoc());
				populateList.add(trainerMenu.getPerfomanceSheet());
				populateList.add(trainerMenu.getSeeAllTrainees());
				populateList.add(trainerMenu.getSeeTrainingSchedule());
				
				for (String mList : populateList)
					System.out.println("--------------" + mList + "----------------------");

				System.out.println("this is trainer");
			}
			if (d_id == 3) {

				populateList.add(traineeMenu.getApplyForLeave());
				populateList.add(traineeMenu.getSeePocs());
				populateList.add(traineeMenu.getSeeTestResults());
				populateList.add(traineeMenu.getSendFeedback());
				
				for (String mList : populateList)
					System.out.println("--------------" + mList + "----------------------");

				System.out.println("this is trainee");
			}

			/*System.out.println("INSIDE AUTHENTICATE NOW CREATING COKKIE ---------------------------");
			Cookie ck = new Cookie("cookieUsername", userName);
			Cookie ck1 = new Cookie("cookiePass", password);

			ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
			HttpServletResponse response = (HttpServletResponse) context.getResponse();
			response.addCookie(ck);
			response.addCookie(ck1);
			System.out.println("INSIDE AUTHENTICATE NOW CREATING COKKIE --------------------ENDS ENDS-------");*/
			return "welcome";

		} else {
			return "login.xhtml?faces-redirect=true&error=" + message;

		}

		/*
		 * if (userName.equalsIgnoreCase(userName1)) { if
		 * (password.equalsIgnoreCase(password1)) {
		 * System.out.println("Success"); setName(user.getName()); return null;
		 * 
		 * } else {
		 * 
		 * System.out.println("Password Not Correct"); return
		 * "login.xhtml?faces-redirect=true&error=Password Not Correct"; }
		 * 
		 * } else { if (password.equalsIgnoreCase(password1)) {
		 * System.out.println("user Not Correct"); return
		 * "login.xhtml?faces-redirect=true&error=UserName Not Correct";
		 * 
		 * } else {
		 * 
		 * System.out.println("User Name And Password Wrong"); return
		 * "login.xhtml?faces-redirect=true&error=UserName and Password Not Correct"
		 * ; }
		 * 
		 * }
		 */

	}

	public String userRegistration() throws Exception {
		userServiceLocal.userRegistration(this);
		return "login.xhtml?faces-redirect=true&error=Registration Successfull";

	}

	public String logout() {
		HttpSession httpSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext()
				.getSession(false);
		httpSession.invalidate();
		return "login";
	}
	
	

}
