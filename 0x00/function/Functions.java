public class Functions {
    private final IncomeRepository inRepo;
    private final ExpenseRepository outRepo;
    private final UserService userService;
    private final VersionService versionService;
    private final EnvironmentService environmentService;
    private final ReleaseService releaseService;

    public Functions(
        IncomeRepository inRepo,
        ExpenseRepository outRepo,
        UserService userService,
        VersionService versionService,
        EnvironmentService environmentService,
        ReleaseService releaseService
    ) {
        this.inRepo = inRepo;
        this.outRepo = outRepo;
        this.userService = userService;
        this.versionService = versionService;
        this.environmentService = environmentService;
        this.releaseService = releaseService;
    }

    public void saveIncome(Income income) {
        inRepo.save(income);
    }

    public void saveExpense(Expense expense) {
        outRepo.save(expense);
    }

    // REST endpoint: único método correto para salvar usuário
    @PostMapping("/user")
    public User saveUser(User user) {
        return userService.save(user);
    }

    public Environment getEnvironment() {
        return environmentService.getEnvironment(getVersion());
    }

    public Release getRelease() {
        return releaseService.getRelease(getVersion());
    }

    private String getVersion() {
        return versionService.getVersion();
    }
}