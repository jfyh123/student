package cn.tarena.ht.utils;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

public class ResultFactory {

	private ResultFactory() {
	}

	private static Result successResult = new Result(
			ResultConstants.SUCCESS_CODE, ResultConstants.SUCCESS_MSG);

	public static Result generateSuccessResult() {
		return successResult;
	}

	public static Result generateResult(String code, String msg) {
		return new Result(code, msg);
	}

	public static Result generateResult(String code, String msg,
			List<?> data) {
		return new Result(code, msg, data);
	}

	public static Result generateResult(String code, String msg, Object data) {
		return new Result(code, msg, data);
	}
	public static Result generateResult(String code, String msg, Object data,HttpServletResponse response) {
		return new Result(code, msg, data,response);
	}

	public static Result generateResult(String code, String msg,
			Map<String, Object> data) {
		return new Result(code, msg, data);
	}
	public static Result generateResultWithDate(String code, String msg,
			Map<String, Object> data) {
		return new Result(code, msg, data);
	}
}


