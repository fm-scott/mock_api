echo ����ִ�д�����£����Ե�...... 
echo ����·����%~dp0
cd %~dp0/..
echo ����
 call svn  update
echo ������ɣ�


echo ....................................... 
echo ..............��ʼ���................. 
echo ....................................... 
cd %~dp0/..
 call mvn clean package -Dmaven.test.skip=true
pause