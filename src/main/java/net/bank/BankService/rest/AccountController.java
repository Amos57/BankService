package net.bank.BankService.rest;

import java.math.BigDecimal;

import net.bank.BankService.model.Account;
import net.bank.BankService.model.Sum;
import net.bank.BankService.service.ServiceAccount;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/bankaccount")
public class AccountController {
	
	@Autowired
	private ServiceAccount serviceAccount;
	
	@RequestMapping(value="{numAccount}" ,method = RequestMethod.POST)
	public ResponseEntity<Account> addAccount(@PathVariable("numAccount")int numAccount){
		if(numAccount<=9999 || numAccount >=100000 )
			return new ResponseEntity<Account>(HttpStatus.BAD_REQUEST);
		 HttpHeaders headers = new HttpHeaders();
	Account account= new Account();
	account.setNumberAccaunt(numAccount);
	account.setSum(BigDecimal.ZERO);
		 account.setNumberAccaunt(numAccount);
		account=serviceAccount.addAccount(account);
		if(account==null)
		return new ResponseEntity<Account>(HttpStatus.CONFLICT);
		
		return new ResponseEntity<Account>(account,headers,HttpStatus.CREATED);
		
		
	}
   @RequestMapping(value="/{numAccount}/deposit/{sum}",method=RequestMethod.PUT)
    public ResponseEntity<Account> addSum(@PathVariable("numAccount") int numAccount,@PathVariable("sum")double sum){
    	if(sum<=0 || numAccount <=9999 || numAccount >=100000)
    		return new ResponseEntity<Account>(HttpStatus.BAD_REQUEST);
    	
    	Account account=serviceAccount.getAccount(numAccount);
    	if(account==null)
    		return new ResponseEntity<Account>(account,HttpStatus.NOT_FOUND);

    	BigDecimal bd=new BigDecimal(sum);
    	bd.add(account.getSum());
    	account.setSum(bd.add(account.getSum()));
    	serviceAccount.addSum(account);
    	
    	return new ResponseEntity<Account>(account,HttpStatus.ACCEPTED);
    	}
    	
    	
   @RequestMapping(value="{numAccount}/withdraw/{sum}",method=RequestMethod.PUT)
    	public ResponseEntity<Sum> takeSum(@PathVariable("numAccount") int numAccount,@PathVariable("sum")double sum){
	   if(sum<=0 || numAccount <=9999 || numAccount >=100000)
   		return new ResponseEntity<Sum>(HttpStatus.BAD_REQUEST);
	   
		Account account=serviceAccount.getAccount(numAccount);
		Sum sumOb=null;
    	if(account==null)
    		return new ResponseEntity<Sum>(sumOb,HttpStatus.NOT_FOUND);
    	sumOb= new Sum();
	   BigDecimal res=account.getSum().subtract(new BigDecimal(sum));
	   if(res.floatValue()<0)
		   return new ResponseEntity<Sum>(sumOb,HttpStatus.CONFLICT);
	   sumOb.setSum(res);
	   account.setSum(res);
	   serviceAccount.takeSum(account);
    	
	   return new ResponseEntity<Sum>(sumOb,HttpStatus.ACCEPTED);
    		
    	}
    
   /**
    * пример, когда можно получить только сумму, без всего объекта
    * 
    * @param numAccount
    * @return
    */
   @RequestMapping(value="{numAccount}/balance",method=RequestMethod.GET)
   public ResponseEntity<BigDecimal> getBalance(@PathVariable("numAccount") int numAccount){
	   if(numAccount <=9999 || numAccount >=100000)
	   		return new ResponseEntity<BigDecimal>(HttpStatus.BAD_REQUEST);
	   
	   Account account=serviceAccount.getAccount(numAccount);
	   if(account==null)
		   return new ResponseEntity<BigDecimal>(new BigDecimal(0),HttpStatus.NOT_FOUND);
	   
	 return new ResponseEntity<BigDecimal>(account.getSum(),HttpStatus.ACCEPTED);
   }
   

}
