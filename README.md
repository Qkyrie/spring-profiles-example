###The Code

This small article will explain how you can use profiles in your spring boot application. It will show you how you can activate them and test them. This article will be accompanied by a [github repository](https://github.com/Qkyrie/spring-profiles-example.git)
> Note: Parts of the example code in the repository uses Java 8 features.

####Using the @Profile annotation


	@Profile("test")
	@Configuration
	public class HelloWorldTestProducer {
	    private Log LOG = 
				LogFactory
				.getLog(HelloWorldTestProducer.class);
	
	
	    @PostConstruct
	    public void init() {
	        LOG.info("test world has been produced");
	    }
	
	    @Bean(name = "helloWorld")
	    public String produceHelloWorld() {
	        return "Hello test world!";
	    }
	
	}

As you can can see, the above class is annotated with **@Configuration**. The annotation that is of utter importance for this blogpost is the **@Profile** annotation. In short, what this means is that this Configuration class will only load if the profile with name *test* is active in the current Environment.

####Starting up the application
Starting up the application is fairly similar to what we have done before. This time however, we'll make use of the more **fluent API** of the *SpringApplicationBuilder*, which, as the name suggests, uses the builder pattern.

You'll see that we create an instance of the application and use the *.profiles(String[] profileNames*) method to activate one or more active profiles.

	@Configuration
	@EnableAutoConfiguration
	@ComponentScan
	public class ProfileApplication {
		public static void main(String[] args) throws Exception {
	        new SpringApplicationBuilder(ProfileApplication.class)
	                .profiles("test")
	                .run(args);
	    }
	}

####Required result

After starting up the application - if you didn't edit anything - using the following command:

	gradle bootRun

you should be seeing the following output:

	c.q.s.e.caching.mvc.GreetController: 
	You can say whatever you like, 
	but based on the active profiles (test) I can only say: 
	Hello test world!



###Testing the setup
How can we easily test this setup? How can we make sure that, when we activate the test-profile, our production profile isn't loaded? How can we write automated, maintainable tests for this? 

Fact is, it's really easy to create integration tests for this kind of setup. Following code is an entire integration test to check that, when a test profile has been used, the correct String will be returned.

	@RunWith(SpringJUnit4ClassRunner.class)
	@ActiveProfiles("test")
	@ContextConfiguration
    	(
    		classes = {ProfileApplication.class}
        )
	public class TestProfileApplicationTest {

        @Autowired
        private GreetController greetController;

        @Test
        public void correctProducerHasBeenDeployed() {
            assertThat(greetController.getHelloWorld())
            .isEqualTo("Hello test world!");
        }
	}

Basically, **@RunWith(SpringJUnit4ClassRunner.class)** tells the test class that it needs to be run with the Spring Junit classrunner, which will create the entire context for you, depending on the configuration you provide in the **@ContextConfiguration** annotation.
**@ActiveProfiles** will make sure that the provided profiles will be activated when tests are run.

###Other ways to activate profiles
In the example we previously explained, we added the profile in the startup method of our boot-application using the builder pattern, which was an equivalent of the 
	
	.setAdditionalProfiles(String profileName)
 method. This is not the only way to activate a profile. 

By default, Spring will look in its current environment for the active profiles. Thee are a few other ways to add some profiles, 2 of which we'll briefly explain below. 

####Using application.properties
If you're using the application.properties file, you can add additional profiles by adding the following key to the file.
	spring.profiles.active=profile1, profile2


####Using jvm-arguments
A last way to add a profile would be to add it as a jvm-argument when starting up your application. 

	java -jar myapp.jar --spring.profiles.active=profile1,profile2

Spring boot will make sure these values are available in the Environment and therefore will be loaded as active profiles.

###Next up
Next time, we'll be looking at profile-specific properties and a new annotation that just has been made available: **@ConditionalOnProperty**. 