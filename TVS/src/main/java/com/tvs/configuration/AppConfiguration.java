//package com.tvs.configuration;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Scope;
//
//import com.tvs.repository.ForumRepository;
//import com.tvs.repository.ForumRepositoryImpl;
//
///*
// * The Configuration annotation denotes that this clss should be used to generate beans
// * and requests for those beans at runtime.
// */
//
//@Configuration
//public class AppConfiguration {
//
//	/*
//	 * The Bean annotation denotes that this method returns a bean.
//	 */
//	@Bean(value="forumRepository")
//	/*
//	 * This defines the scope of our Spring bean.
//	 */
//	@Scope(scopeName="singleton")
//	public ForumRepository getForumRepository() {
//		return new ForumRepositoryImpl();
//	}
//}
