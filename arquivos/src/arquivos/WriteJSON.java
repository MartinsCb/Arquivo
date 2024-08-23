package arquivos;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class WriteJSON {

    public static void main(String[] args) throws IOException {
        
        User user1 = new User();
        user1.setCpf("39939020848");
        user1.setLogin("Andre");
        user1.setPassword("230791");
        user1.setName("Martins");
        
        User user2 = new User();
        user2.setCpf("39039020848");
        user2.setLogin("Anyone");
        user2.setPassword("1234");
        user2.setName("someone");
        
        List<User> users = new ArrayList<User>();
        users.add(user1);
        users.add(user2);
        
        // Usando o objeto Gson configurado para formatação bonita
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        
        // Convertendo a lista de usuários para JSON usando o objeto Gson configurado
        String jsonUser = gson.toJson(users);
        
        System.out.print(jsonUser);
        
        // Escrevendo o JSON no arquivo
        FileWriter fileWriter = new FileWriter("C:\\Users\\marti\\git\\repository5\\arquivos\\src\\arquivos\\fileJson.json");
        fileWriter.write(jsonUser);
        fileWriter.flush();
        fileWriter.close();
        
        //****************************READING A JSON FILE ***********************************     
        FileReader fileReader = new FileReader("C:\\Users\\marti\\git\\repository5\\arquivos\\src\\arquivos\\fileJson.json");
        
        // Parseando o JSON do arquivo para um JsonArray
        JsonArray jsonArray = JsonParser.parseReader(fileReader).getAsJsonArray();
        List<User> users1 = new ArrayList<User>();
        
        // Percorrendo cada JsonElement do JsonArray e desserializando para o objeto User
        for (JsonElement jsonElement : jsonArray) {
            User user = gson.fromJson(jsonElement, User.class);
            users1.add(user);
        }
        
        // Fechar o FileReader
        fileReader.close();
        
        // Exibindo os usuários lidos do JSON
        System.out.println("Json File Read: " + users1);
    }
}
