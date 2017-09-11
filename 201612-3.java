// 9:50

import java.util.Scanner;
import java.util.LinkedList;

class Author{
	public String name;
	public boolean hasPrivilege;
	public int privilege;

	public Author(String name,boolean hasPrivilege,int privilege){
		this.name = name;
		this.hasPrivilege = hasPrivilege;
		this.privilege = privilege;
	}
}

class Role{
	public String name;
	public LinkedList<Author> authors = new LinkedList<>();

	public Role(String name){
		this.name = name;
	}
}

class User{
	public String name;
	public LinkedList<Role> roles = new LinkedList<>();

	public User(String name){
		this.name = name;
	}

	// TODO modify search function here
}

public class AuthorSearch{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// handle authors
		int authorcount = Integer.parseInt(sc.nextLine());
		LinkedList<Author> authorList = new LinkedList<>();
		for(int i=0;i<authorcount;i++){
			String authorString = sc.nextLine();
			if(authorString.contains(":")){
				String [] authorInfo = authorString.split(":");
				authorList.add(new Author(authorInfo[0],true,Integer.parseInt(authorInfo[1])));
			}else{
				authorList.add(new Author(authorString,false,-1));
			}
		}

		// handle roles
		int rolecount = Integer.parseInt(sc.nextLine());
		LinkedList<Role> roleList = new LinkedList<>();
		for(int i=0;i<rolecount;i++){
			String roleString = sc.nextLine();
			String [] roleInfo = roleString.split(" ");
			Role role = new Role(roleInfo[0]);
			int count = Integer.parseInt(roleInfo[1]);
			for(int j=0;j<count;j++){
				String authorString = roleInfo[2+j];
				if(authorString.contains(":")){
					String [] authorInfo = authorString.split(":");
					role.authors.add(new Author(authorInfo[0],true,Integer.parseInt(authorInfo[1])));
				}else{
					role.authors.add(new Author(authorString,false,-1));
				}
			}
			roleList.add(role);
		}

		// handle user
		int usercount = Integer.parseInt(sc.nextLine());
		LinkedList<User> userList = new LinkedList<>();
		for(int i=0;i<usercount;i++){
			String userString = sc.nextLine();
			String [] userInfo = userString.split(" ");
			User user = new User(userInfo[0]);
			int count = Integer.parseInt(userInfo[1]);
			for(int j=0;j<count;j++){
				String roleString = userInfo[2+j];
				for(Role role:roleList){
					if(role.name.equals(roleString)){
						user.roles.add(role);
						break;
					}
				}
			}
			userList.add(user);
		}

		// search privilege in userList
		int searchCount = Integer.parseInt(sc.nextLine());
		for (int i=0;i<searchCount;i++ ) {
			String searchString = sc.nextLine();
			String [] searchInfo = searchString.split(" ");
			String searchUserName = searchInfo[0];
			String searchAuthorString = searchInfo[1];

			String searchAuthorName;
			int searchAuthorprivilege;
			Author sampleAuthor = null;

			if(searchAuthorString.contains(":")){
				searchAuthorName = searchAuthorString.split(":")[0];
				searchAuthorprivilege = Integer.parseInt(searchAuthorString.split(":")[1]);
			}else{
				searchAuthorName = searchAuthorString;
				searchAuthorprivilege = -1;
			}

			for(Author a:authorList){
				if(a.name.equals(searchAuthorName)){
					sampleAuthor = a;
					break;
				}
			}

			if(sampleAuthor==null){
				System.out.println(false);
				continue;
			}

			boolean discoverUser = false;
			boolean discoverAuthor = false;
			if(searchAuthorString.contains(":")){
				for(User u:userList){
					if(u.name.equals(searchUserName)){
						discoverUser = true;
						for(Role r:u.roles){
							for(Author a:r.authors){
								if(a.name.equals(searchAuthorName) && a.privilege>=searchAuthorprivilege){
									System.out.println(true);
									discoverAuthor = true;
									break;
								}
							}	
							if(discoverAuthor){
								break;
							}
						}
						break;
					}
				}
				if(!discoverAuthor){
					System.out.println(false);
				}
			}else{
				if(sampleAuthor.hasPrivilege){
					int maxPrivilege = -1;
					for(User u:userList){
						if(u.name.equals(searchUserName)){
							discoverUser = true;
							for(Role r:u.roles){
								for(Author a:r.authors){
									if(a.name.equals(searchAuthorName)){
										discoverAuthor = true;
										if(a.privilege>=maxPrivilege){
											maxPrivilege = a.privilege;
										}
										break;
									}
								}
							}
							break;
						}
					}

					if(!discoverUser || !discoverAuthor){
						System.out.println(false);
					}
					if(discoverAuthor){
						System.out.println(maxPrivilege);
					}
					
				}else{
					for(User u:userList){
						if(u.name.equals(searchUserName)){
							discoverUser = true;
							for(Role r:u.roles){
								for(Author a:r.authors){
									if(a.name.equals(searchAuthorName)){
										System.out.println(true);
										discoverAuthor = true;
										break;
									}
								}
								if(discoverAuthor){
									break;
								}
							}
							break;
						}
					}
					if(!discoverAuthor){
						System.out.println(false);
					}
				}
			}
			
		}
		// release resource
		sc.close();
	} // function end

}