package spring.mvc.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SelfTransactionManager {
    private TransactionStatus transactionStatus;


    @Autowired
    private DataSourceTransactionManager dataSourceTransactionManager;


    public TransactionStatus begin(){
        transactionStatus = dataSourceTransactionManager.getTransaction(new DefaultTransactionAttribute());
        return transactionStatus;
    }


    public void commit(TransactionStatus transactionStatus){
        dataSourceTransactionManager.commit(transactionStatus);
    }


    public void rollBack(){
        System.out.println("开始回滚");
        dataSourceTransactionManager.rollback(transactionStatus);
    }
}
