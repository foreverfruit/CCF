/**
 * TODO 未完成，思路混乱
 */

import java.util.ArrayList;
import java.util.Scanner;

class Author{
	public String name;
	public String privilege;
	
	public Author() {
	}
}

class Role{
	public String name;
	public ArrayList<Author> authors = new ArrayList<>();
	
	public Role(String name) {
		this.name = name;
	}
}

class User{
	public String name;
	public ArrayList<Role> roles = new ArrayList<>();
	
	public User(String name) {
		this.name = name;
	}
	
	// find author without privilege
	public void hasAuthor(String authorName) {
		for(Role role : roles) {
			for(Author author : role.authors) {
				if(author.name.equals(authorName)) {
					System.out.println(true);
				}
			}
		}
		System.out.println(false);
	}
	
	public void getPrivilege(String authorName) {
		int curPri = -1;
		for(Role role : roles) {
			for(Author author : role.authors) {
				if(author.name.equals(authorName)) {
					int privilege = Integer.parseInt(author.privilege);
					if(curPri<privilege) {
						curPri = privilege;
					}
				}
			}
		}
		
		if(curPri==-1) {
			System.out.println(false);
		}else {
			System.out.println(curPri);
		}
	}
	
	// find author with privilege
	public void hasAuthor(String authorName,String privilege) {
		for(Role role : roles) {
			for(Author author : role.authors) {
				if(author.name.equals(authorName) && privilege.equals(author.privilege)) {
					System.out.println(true);
					return;
				}
			}
		}
		System.out.println(false);
	}
	
}

public class N20161203 {
	
	public static void main_N20161203(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// read authors, skip
		int authorCount = Integer.parseInt(sc.nextLine());
		ArrayList<Author> as = new ArrayList<>();
		for(int i=0;i<authorCount;i++) {
			String s = sc.nextLine();
			Author a = new Author();
			if(s.contains(":")) {
				a.name = s.split(":")[0];
				a.privilege =  " ";
			}else {
				a.name = s;
				a.privilege = null;
			}
			as.add(a);
		}
		
		// read roles
		ArrayList<Role> roles = new ArrayList<>();
		int roleCount = Integer.parseInt(sc.nextLine());
		for(int i=0;i<roleCount;i++) {
			String[] data = sc.nextLine().split(" ");
			Role role = new Role(data[0]);
			int roleAuthorCount = Integer.parseInt(data[1]);
			for(int j=0;j<roleAuthorCount;j++) {
				Author author = new Author();
				if(data[2+j].contains(":")) {
					String[] a = data[2+j].split(":");
					author.name = a[0];
					author.privilege = a[1];
				}else {
					author.name = data[2+j];
					author.privilege = null;
				}
				role.authors.add(author);
			}
			roles.add(role);
		}
		
		// read users
		int userCount = Integer.parseInt(sc.nextLine());
		ArrayList<User> users = new ArrayList<>();
		for(int i=0;i<userCount;i++) {
			String [] userData = sc.nextLine().split(" ");
			String name = userData[0];
			int roleCountOfUser = Integer.parseInt(userData[1]);
			User user = new User(name);
			for(int j=0;j<roleCountOfUser;j++) {
				String roleName = userData[2+j];
				for(Role r:roles) {
					if(r.name.equals(roleName)) {
						user.roles.add(r);
					}
				}
			}
			users.add(user);
		}
		
		// search
		int searchCount = Integer.parseInt(sc.nextLine());
		for(int i=0;i<searchCount;i++) {
			String [] data = sc.nextLine().split(" ");
			String userName = data[0];
			String authorInfo = data[1];
			int count = 0;
			for(;count<users.size();count++) {
				User u = users.get(count);
				if(u.name.equals(userName)) {
					if(authorInfo.contains(":")) {
						String [] infos = authorInfo.split(":");
						String authorName = infos[0];
						String privilege = infos[1];
						u.hasAuthor(authorName, privilege);
					}else {
						for(Author au:as) {
							if(au.name.equals(authorInfo)) {
								if(au.privilege==null)
									u.hasAuthor(authorInfo);
								else
									u.getPrivilege(authorInfo);
							}
						}
					}
					break;
				}
			}
			if(count==users.size()) {
				System.out.println(false);
			}
		}
		
		// output
		sc.close();
	}
}
