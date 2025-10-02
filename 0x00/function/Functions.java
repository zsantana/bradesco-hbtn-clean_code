public class Functions {

    // Repositórios e serviços devem ser declarados aqui (Assumindo injeção via construtor ou @Autowired)
    private final IncomeRepository inRepo;
    private final ExpenseRepository outRepo;
    private final UserService userService;
    private final UserRepository userRepository;
    private final VersionService versionService;
    private final EnvironmentService environmentService;
    private final ReleaseService releaseService;

    // Construtor assumido para injecção dos dependentes
    public Functions(
        IncomeRepository inRepo,
        ExpenseRepository outRepo,
        UserService userService,
        UserRepository userRepository,
        VersionService versionService,
        EnvironmentService environmentService,
        ReleaseService releaseService
    ) {
        this.inRepo = inRepo;
        this.outRepo = outRepo;
        this.userService = userService;
        this.userRepository = userRepository;
        this.versionService = versionService;
        this.environmentService = environmentService;
        this.releaseService = releaseService;
    }

    // Cada método deve fazer somente uma coisa e ter argumentos mínimos

    public void saveIncome(Income income){
        inRepo.save(income);
    }

    public void saveExpense(Expense expense){
        outRepo.save(expense);
    }

    @PostMapping("/user")
    public User saveUser(User user){
        return userService.save(user);
    }

    // Argumentos mínimos e nome claro
    public void saveUser(User user){
        userRepository.save(user);
    }

    // Sem efeitos colaterais, lógica separada
    public User saveUserNoSideEffects(User user){
        return userRepository.save(user);
    }

    public void setRole(User user){
        user.setRole(user);     
    }

    // Evite duplicação: extraia para um método privado
    public Environment getEnvironment(){
        return environmentService.getEnvironment(getVersion());
    }
    public Release getRelease(){
        return releaseService.getRelease(getVersion());
    }
    private String getVersion(){ 
        return versionService.getVersion();
    }
}