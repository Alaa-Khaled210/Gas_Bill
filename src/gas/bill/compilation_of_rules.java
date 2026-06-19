/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gas.bill;

/**
 *
 * @author EL FAROUQ
 */

import javax.rules.RuleRuntime;
import javax.rules.RuleServiceProvider;
import javax.rules.RuleServiceProviderManager;
import javax.rules.StatefulRuleSession;
import javax.rules.StatelessRuleSession;
import javax.rules.admin.RuleAdministrator;
import javax.rules.admin.RuleExecutionSet;
import java.io.*;
import java.util.*;
import static java.lang.System.out;
import java.util.Scanner;

public class compilation_of_rules {
    
    public compilation_of_rules(){
    try{
     // Load the rule service provider of the reference
      // implementation.
      // Loading this class will automatically register this
      // provider with the provider manager.
      Class.forName( "org.jruleengine.RuleServiceProviderImpl" );

      // Get the rule service provider from the provider manager.
      RuleServiceProvider serviceProvider = RuleServiceProviderManager.getRuleServiceProvider( "org.jruleengine" );

      // get the RuleAdministrator
      RuleAdministrator ruleAdministrator = serviceProvider.getRuleAdministrator();

      // get an input stream to a test XML ruleset
      // This rule execution set is part of the TCK.
      InputStream inStream = new FileInputStream( "src\\gas_bill_rules.xml" );

      // parse the ruleset from the XML document
      RuleExecutionSet res1 = ruleAdministrator.getLocalRuleExecutionSetProvider( null ).createRuleExecutionSet( inStream, null );
      inStream.close();
      

      // register the RuleExecutionSet
      String uri = res1.getName();
      ruleAdministrator.registerRuleExecutionSet(uri, res1, null );
      
      // Get a RuleRuntime and invoke the rule engine.
      RuleRuntime ruleRuntime = serviceProvider.getRuleRuntime();  
        
     // create a StatelessRuleSession
      StatelessRuleSession statelessRuleSession =
              (StatelessRuleSession) ruleRuntime.createRuleSession(uri,
              new HashMap(), RuleRuntime.STATELESS_SESSION_TYPE);
      
     
       Consumption myConsumption = new Consumption();
       myConsumption.setConsum(myConsumption.getScan());
       
        
      The_Bill bill = new The_Bill();
       bill.setThe_chipe(" ");
      
     // Create a input list.
      //هنا انقلى كل اوبجيكت الكلاسات فى ليستة وضعيهم داخل ليستة النتيجة اللى المفروض تكون البيانات بها مؤقتة 
      List input = new ArrayList();
      input.add(myConsumption);
      input.add(bill);
      // Execute the rules without a filter.
      
      List results = statelessRuleSession.executeRules(input);

      
      // Loop over the results.
      Iterator itr = results.iterator();
     
     //System.out.println("bill = " + bill.getThe_chipe());
          String ls;
      while(itr.hasNext()) {
              Object obj = itr.next();
              if (obj instanceof The_Bill)                  
                      System.out.println("انت من ضمن : " + ((The_Bill) obj).getThe_chipe() );
             
                                                         
              
      }      

      // Release the session.
      statelessRuleSession.release();
      
      
      
      
     }
    catch (NoClassDefFoundError e) {
      if (e.getMessage().indexOf("Exception") != -1) {
        System.err.println("Error: The Rule Engine Implementation could not be found.");
      }
      else {
        System.err.println("Error: " + e.getMessage());
      }
    }
    catch (Exception e) {
      e.printStackTrace();
    }
        
    }
    
    
  public static void main(String[] args) {
    compilation_of_rules cor = new compilation_of_rules();
  }
    

}