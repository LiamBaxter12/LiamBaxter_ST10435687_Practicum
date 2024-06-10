# LiamBaxter_ST10435687_Practicum
Android Application for Practicum
My Weather App
****************************************************************
Detailed step by step instruction manual on how to install and operate my application.
**********************************************************************

Step 1: Open Android Studio.
Step 2: Run the application.
Step 3: Press button labelled "view weather" to navigate to next page or button labelled "exit" to leave.
Step 4: Follow what is prompted until complete, press button labelled "Average" to calculate average temperature.
Step 5: The average temperature will display in a shaded box below.
Step 6: Press the button labelled '"View Details" to view a more detailed weather report.
Step 7: Close application if you have finished using it.
****************************************************************************
Pseudocode:

Screen 1
START MainActivity
    ON_CREATE
        SET Button1 TO findViewById(Button1)
        Button1 ON_CLICK
            CREATE intent TO Weather1
            START_ACTIVITY(intent)
        END Button1 ON_CLICK
END MainActivity
**********************************************
Screen 2
START Weather1
    DECLARE num[] maxTempList
    DECLARE num[] minTempList
    DECLARE string[] dayslist
    DECLARE string[] weatherConditionsList

    ON_CREATE
        SET dayEditText TO findViewById(days)
        SET maxTempEditText TO findViewById(max1)
        SET minTempEditText TO findViewById(min)
        SET weatherConditionEditText TO findViewById(weather)
        SET averageButton TO findViewById(button)
        SET averageTextView TO findViewById(textView9)
        SET clearButton TO findViewById(clear)
        SET exitButton TO findViewById(exit)

        averageButton ON_CLICK
            SET day TO dayEditText.getText
            SET maxTemp TO maxTempEditText.getText TO_INT
            SET minTemp TO minTempEditText.getText TO_INT
            SET condition TO weatherConditionEditText.getText

            IF day IS_NOT_EMPTY AND maxTemp IS_NOT_NULL AND minTemp IS_NOT_NULL AND condition IS_NOT_EMPTY
                ADD maxTemp TO maxTempList
                ADD minTemp TO minTempList

                SET averageMaxTemp TO sum(maxTempList) / size(maxTempList)
                SET averageMinTemp TO sum(minTempList) / size(minTempList)

                SET averageTextView TO "Average Max Temp: " + averageMaxTemp + "\nAverage Min Temp: " + averageMinTemp

                CLEAR dayEditText
                CLEAR maxTempEditText
                CLEAR minTempEditText
                CLEAR weatherConditionEditText
            ELSE
                SET averageTextView TO "Please fill in all fields"
            END IF
        END averageButton ON_CLICK

        clearButton ON_CLICK
            CLEAR dayEditText
            CLEAR maxTempEditText
            CLEAR minTempEditText
            CLEAR weatherConditionEditText
        END clearButton ON_CLICK

        exitButton ON_CLICK
            FINISH_AFFINITY
        END exitButton ON_CLICK

        button2 ON_CLICK
            CREATE intent TO Screen2
            ADD dayslist TO intent
            ADD maxTempList TO intent
            ADD minTempList TO intent
            ADD weatherConditionsList TO intent
            START_ACTIVITY(intent)
        END button2 ON_CLICK
END Weather1
***********************************************
Screen 3
START Screen2
    ON_CREATE
        SET detailsTextView TO findViewById(textView2)

        GET daysList FROM intent
        GET maxTempList FROM intent
        GET minTempList FROM intent
        GET weatherConditionsList FROM intent

        DECLARE string details

        FOR i FROM 0 TO size(daysList) - 1
            APPEND "Day: " + daysList[i] + ", Max Temp: " + maxTempList[i] + ", Min Temp: " + minTempList[i] + ", Condition: " + weatherConditionsList[i] + "\n" TO details
        END FOR

        SET detailsTextView TO details

        SET backButton TO findViewById(back)
        backButton ON_CLICK
            FINISH
        END backButton ON_CLICK
END Screen2

  
