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

/**
 * Adds a random greeting to the page.
 */
 
// function addRandomGreeting() {
//   const greetings =
//       ['Hello world!', '¡Hola Mundo!', '你好，世界！', 'Bonjour le monde!'];

//   // Pick a random greeting.
//   const greeting = greetings[Math.floor(Math.random() * greetings.length)];

//   // Add it to the page.
//   const greetingContainer = document.getElementById('greeting-container');
//   greetingContainer.innerText = greeting;
// }
function loadTasks() {
  fetch('/form-content').then(response => response.json()).then((tasks) => {
    const comment = document.getElementById('data-container');
    tasks.forEach((task) => {
      comment.innerText=task;
    })
  });
}
function createParagraph(text) {
  const paragraph = document.createElement('p');
//   body.querySelector('#image-Url').src = listing.imageUrl;
  paragraph.innerText = text;
  return paragraph;
}
// function fetchBlobstoreUrlAndShowForm() {
//   fetch('/blobstore-upload-url')
//       .then((response) => {
//         return response.text();
//       })
//       .then((imageUploadUrl) => {
//         const messageForm = document.getElementById('my-post');
//         messageForm.action = imageUploadUrl;
//       });
// }