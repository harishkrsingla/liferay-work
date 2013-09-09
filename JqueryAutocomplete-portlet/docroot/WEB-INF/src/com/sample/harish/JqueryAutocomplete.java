package com.sample.harish;

import com.google.gson.Gson;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.sample.harish.model.Student;
import com.sample.harish.service.StudentLocalServiceUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

public class JqueryAutocomplete extends MVCPortlet {
	
	@Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		// TODO Auto-generated method stub
		super.doView(renderRequest, renderResponse);
	}
	
	@Override
	public void serveResource(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws IOException,
			PortletException {
		String action = ParamUtil.getString(resourceRequest, "action");
		if(action.equals("autocompleteCall"))
		{
			String fieldName = ParamUtil.getString(resourceRequest, "fieldName");
			String term = ParamUtil.getString(resourceRequest, "term");
			String res = getAutocompleteListData(fieldName,term);
			resourceResponse.getWriter().write(res);
		}
	}
	
	private String getAutocompleteListData(String fieldName, String term) {
		
		List<String> courseList = new ArrayList<String>();
		Gson gson = new Gson();
		List<Student> students = null;
		try {
			students = StudentLocalServiceUtil.findByCourseLike(term + "%");
		} catch (SystemException e) {
			e.printStackTrace();
		}
		if (Validator.isNotNull(students)) {
			for (Student stud : students) {
				courseList.add(stud.getCourse());
			}
		}
		return gson.toJson(courseList);
	}

	public void submitCourse(ActionRequest request, ActionResponse response)
	{
		String course = ParamUtil.getString(request, "course");
		System.out.println("Process Course: " + course);
	}
}
