package exam;

import di.Inject;

public class AccoutService {
    @Inject
    private AccountRepository accountRepository;
    public void join(){
        System.out.println("service.join");
        accountRepository.save();
    }
}
