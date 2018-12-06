package com.etc.servers;

@Controller
@RequestMapping(value="/face")
@RestController
public class FaceController {

    @Autowired
    private FaceUserService faceService;

    @RequestMapping(value="/photograph")
    public JsonResult getFace(String imgString,String name) throws IOException {


        String str = FaceUtil.checkFace(imgString);

         JSONObject json = JSONObject.fromObject(str);
         try {
             String faces = json.getString("faces");
             if("[]".equals(faces)) {
                 return new JsonResult("0", "�Բ������ϴ��Ĳ����û�ͷ�������Ƭ��������꣬�������ϴ���", null);
             }
             JSONObject josnToken = JSONObject.fromObject(faces.substring(1, faces.length()-1));
             String token = josnToken.getString("face_token");
             FaceUser user = new FaceUser();
             user.setName(name);
             user.setFaceToken(token);
             faceService.add(user);
        } catch (Exception e) {
            // TODO: handle exception   
             e.printStackTrace();
             return new JsonResult("0", "ϵͳ��æ�����Ժ����ԣ�", null);
        }
       return new JsonResult("1", "�ϴ��ɹ������¼��", null);
    }

}
