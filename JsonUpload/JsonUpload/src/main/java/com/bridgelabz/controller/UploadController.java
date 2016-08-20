package com.bridgelabz.controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import com.bridgelabz.util.JSONUtils;
import com.bridgelabz.validator.FileValidator;
import com.bridgelabz.dao.TableDao;
import com.bridgelabz.model.UploadedFile;
// TODO: Auto-generated Javadoc

/**
 * The Class UploadController.
 */
@Controller("abc")
public class UploadController {

	/** The json util. */
	@Autowired
	JSONUtils jsonUtil;

	/** The file validator. */
	@Autowired
	FileValidator fileValidator;

	/** The table dao. */
	@Autowired
	TableDao tableDao;

	/**
	 * M bass home.
	 *
	 * @return the model and view
	 */
	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	public ModelAndView mBassHome() {
		System.out.println("dashboard json page open");
		Map<String, Object> model = new HashMap<String, Object>();
		return new ModelAndView("databaseDashBoard", model);
	}

	/**
	 * Gets the upload form.
	 *
	 * @param uploadedFile
	 *            the uploaded file
	 * @param result
	 *            the result
	 * @return the upload form
	 */
	/**
	 * @param uploadedFile
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "/fileUploadForm", method = RequestMethod.GET)
	public ModelAndView getUploadForm(@ModelAttribute("uploadedFile") UploadedFile uploadedFile, BindingResult result) {
		System.out.println("upload json page open");
		Map<String, Object> model = new HashMap<String, Object>();
		return new ModelAndView("uploadForm", model);
	}

	/**
	 * @param uploadedFile
	 * @param result
	 * @param req
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/fileUpload")
	public ModelAndView fileUploaded(@ModelAttribute("uploadedFile") UploadedFile uploadedFile, BindingResult result,
			HttpServletRequest req) throws Exception {
		InputStream inputStream = null;
		MultipartFile file = uploadedFile.getFile();
		inputStream = file.getInputStream();
		String data = " ";
		InputStreamReader ios = new InputStreamReader(inputStream);
		BufferedReader br = new BufferedReader(ios);
		String line;
		while ((line = br.readLine()) != null) {
			data += line + "\n";
		}
		fileValidator.validate(uploadedFile, result);
		if (result.hasErrors()) {
			return new ModelAndView("uploadForm");
		}
		boolean jsonStringValid = JSONUtils.isJSONValid(data);
		if (jsonStringValid == false) {
			return new ModelAndView("invalidJson");
		}
		tableDao.getFile(data, result);
		return new ModelAndView("showFile");
	}
}