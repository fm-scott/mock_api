echo 正在执行打包更新，请稍等...... 
echo 更新路径：%~dp0
cd %~dp0/..
echo 更新
 call svn  update
echo 更新完成！


echo ....................................... 
echo ..............开始打包................. 
echo ....................................... 
cd %~dp0/..
 call mvn clean package -Dmaven.test.skip=true
pause