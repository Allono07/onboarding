
1. Design
Application low-level design: https://drive.google.com/file/d/1T0ikEpcS00WRtWk3vtaCynryIOJ9mt3T/view?usp=sharing 

For the application I have used MVMM design arctiecture so that I have separate module to handle the UI and the business logic.

2. Scalability: The application loads the question dynamically from the json file present in the assets folder. Hence  you can add as many questions in the JSON file and the UI model will handle it.

3. Size: I have used less number of depency and there are no unused methods. Further, on the production application the proguard is applied whille generating the release APK.  
