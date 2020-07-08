// Copyright 2019 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.sps.servlets;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** Servlet that returns some example content. TODO: modify this file to handle comments data */
@WebServlet("/text")
public class DataServlet extends HttpServlet {

    // public static void main(String[] args){ 
    // ArrayList<String> favorite = new ArrayList<String>();
    //     favorite.add("Red");
    //     favorite.add("Orange");
    //     favorite.add("Pho");
        
    // }
 
//   @Override
//   public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
//         Gson gson = new Gson();
//         String json = gson.toJson();
//         response.setContentType("application/json;");
//         response.getWriter().println(json);
//   }
   @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
    // Get the input from the form.
    String text = request.getParameter("text-input");
    Entity taskEntity = new Entity("Task");
    taskEntity.setProperty("text", text);
 DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
 datastore.put(taskEntity);
    // Respond with the result.
    response.setContentType("text/html;");
    response.getWriter().println(text);
  }
  private String getParameter(HttpServletRequest request, String name, String defaultValue) {
    String value = request.getParameter(name);
    if (value == null) {
      return defaultValue;
    }
    return value;
  }
}
