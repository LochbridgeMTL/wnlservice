## wnlservice Project

You are currently on the `firstdraft` branch.

Follow these steps to get started:

1. Git-clone this repository.

        $ git clone git://github.com/spray/wnlservice.git

2. Change directory into your clone:

        $ cd wnlservice

3. Launch SBT:

        $ sbt

4. Compile everything and run all tests:

        > test

5. Start the application:

        > re-start

6. Browse to [http://localhost:8080](http://localhost:8080/)

7. Stop the application:

        > re-stop


Services:

1. Get: http://localhost:8080/getwnl
       the service returns email subject and content in json format
       {
         "subject": "test subject",
         "content": "test content"
       }


2. Post: http://localhost:8080/postwnl
        the service takes data in json format
        {
          "subject": "test subject",
          "content": "test content"
        }

