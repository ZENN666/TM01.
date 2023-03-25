import org.json.JSONArray;
import org.json.JSONObject;

import javax.management.modelmbean.ModelMBean;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class ConntFarm {
    public static int jumlahdata;
    public static void main(String[] args) throws IOException {
        ContURI koneksisaya = new ContURI();
        URL myAddres = koneksisaya.buildURL("https://farmasi.mimoapps.xyz/mimoqss2auyqD1EAlkgZCOhiffSsFl6QqAEIGtM");
        String response = koneksisaya.getResponseFromHttpUrl(myAddres);
        System.out.println(response);

        assert response !=null;
        JSONArray responseJSON = new JSONArray(response);
        ArrayList<ModelFarmasi> modelFarmasis =
        new ArrayList<>();
        for (int i=0;i<responseJSON.length();i++){
            ModelFarmasi resModel = new ModelFarmasi();
            JSONObject myJSONObject = responseJSON.getJSONObject(i);
            resModel.setI_code(myJSONObject.getString("i_barcode"));
            resModel.setI_code(myJSONObject.getString("g_sell"));
            resModel.setI_code(myJSONObject.getString("i_qty"));
            modelFarmasis.add(resModel);


        }

        System.out.println("Response are");
        for (int index=0;index <modelFarmasis.size();index++) {
            System.out.println("nama barang : " +
                    modelFarmasis.get(index).getI_barcode());

        }



    }
}


