package com.cts.sample.action;

import java.util.List;
import org.apache.log4j.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.cts.sample.dao.Customer;
import com.cts.sample.dao.CustomerDBUtil;
import com.cts.sample.form.CustomerForm;





public class CustomerAction extends Action {
	final static Logger logger = Logger.getLogger(CustomerAction.class);

	public ActionForward execute(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response) throws Exception {
		//logs debug
		if(logger.isDebugEnabled()){
			logger.debug("WelcomeAction.execute()");
		}
               if(logger.isInfoEnabled()){
			logger.info("This is info in Action class :");
		}

		//logs exception
		logger.error("This is Error message", new Exception("Testing"));
		//logs info
		logger.info("My first log*************************");
		
		System.out.println("We are in Customer Action..");
		CustomerForm customerForm =(CustomerForm)form;
		//customerForm.setCustomer(CustomerDBUtil.getCustomerDetails(customerForm.getCustomerID()));
		List<Customer> customerList= CustomerDBUtil.getCustomerList();
		request.setAttribute("CustomerObject", customerList);
		return mapping.findForward("success");
	}
	

}
