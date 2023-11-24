package com.kensy.trabalhojavafx;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.json.JSONObject;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ResourceBundle;

public class ImageController implements Initializable {

    @FXML
    private ImageView imagemAnime;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String apiUrl = "https://pic.re/image";

        try {
            URL urlApi = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) urlApi.openConnection();
            connection.setRequestMethod("POST");

            // código 200?
            if (connection.getResponseCode() == 200) {
                InputStream inputStream = connection.getInputStream();
                String jsonString = new java.util.Scanner(inputStream).useDelimiter("\\A").next();
                JSONObject json = new JSONObject(jsonString);
                String imageUrl = json.getString("file_url");
                URL imageUrlObj = new URL(imageUrl);
                InputStream imageStream = imageUrlObj.openStream();

                Image image = new Image(imageStream);

                imagemAnime.setImage(image);
            } else {
                System.out.println("Falha ao obter os dados. Código de resposta: " + connection.getResponseCode());
            }

            // fecha a conexão
            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
