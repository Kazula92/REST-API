call gradlew build
if "%ERRORLEVEL%" == "0" goto task
echo.
echo GRADLEW BUILD has errors - breaking work
goto fail

:tasks
start chrome "http://localhost:8080/crud/v1/tasks/getTasks"
if "%ERRORLEVEL%" == "0" goto end
echo.
echo Cannot open Chrome and show tasks - breaking work
goto fail

:fail
echo.
echo There were errors

:end
echo.
echo Work is finished.