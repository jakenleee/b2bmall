package priv.jesse.mall.web.enquiry;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import priv.jesse.mall.service.QueryService;
import priv.jesse.mall.utils.FileUtil;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/enquiry")
public class EnquiryController {

    @Resource
    private QueryService queryService;


    /**
     * 询价单列表
     * */
    @RequestMapping("/toEnquiryOrderList.html")
    public String toEnquiryOrderList(){
        return "mall/enquiry/enquiryOrder";
    }

    /**
     *发布询价
     */
    @RequestMapping("/toEnquiryPublic.html")
    public String toEnquiryPublic(){
            return "mall/enquiry/enquiryPublic";
    }


    /**
     *test页面
     */
    @RequestMapping("/toModel.html")
    public String toModel(){
        return "mall/enquiry/model";
    }

    /**
     * 发布询价b
     * */
    @RequestMapping(value = "/submitEnquiry.do", method = RequestMethod.POST)
    public void submitEnquiry(MultipartFile image,
                                int productId,
                                String productTitle,
                                String productType,
                                int productNum,
                                String desc,

                                HttpServletRequest request,
                                HttpServletResponse response
                                ) throws Exception {
        String imgUrl = FileUtil.saveFile(image);
        queryService.submitEnquiry(productId,productTitle,productType,productNum,desc,imgUrl,request,response);

        }

}
