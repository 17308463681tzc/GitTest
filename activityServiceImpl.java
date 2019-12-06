public Message miniProgramLogin(HttpServletRequest httpServletRequest){
        String mobile = httpServletRequest.getParameter("mobile");
        //检查用户是否存在
        String requestSource = "miniProgram";
        Customer customer = customerService.selectAvailableCustomerByPhone(mobile);
        if (customer == null){
            return new Message().error(1, "未查找到用户或暂不能登录");
        }
        String verifyCode= httpServletRequest.getParameter("verifyCode");
        return loginService.miniProgramLogin(mobile, verifyCode, httpServletRequest);
    }
	
	/**
     * 将用户信息计入crm系统
     * @date 2019/7/15 9:46
     * @param httpServletRequest
     */
    @RequestMapping(value = "/marketingOperate", method = RequestMethod.POST)
    public Message marketingOperate(String phone, Long tmkId, Long giftPackageId, HttpServletRequest request){
        String openid = request.getHeader("openid");
        return loginService.marketingOperate(phone, tmkId,giftPackageId, openid);
    }
	
	
	    Message miniProgramLogin(String mobile, String verifyCode, HttpServletRequest request);

    public Message WeChatAppletLogin(String phone,String verifyCode, String code,
        String encryptedData, String iv, HttpServletRequest request);

    public String getUnionId(String code, String encryptedData, String iv);

    Message marketingOperate(String phone,  Long tmkId,Long giftPackageId, String openid);
	
	
	新上传的