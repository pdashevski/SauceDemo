>mvn versions:display-dependency-updates
```sh
[INFO] The following dependencies in Dependencies have newer versions:
[INFO]   org.seleniumhq.selenium:selenium-java ....... 3.141.59 -> 4.0.0-beta-1
[INFO]   org.testng:testng ..................................... 7.1.0 -> 7.3.0

```
------------

>mvn clean test
```sh
[INFO] Tests run: 9, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 37.018 s - in TestSuite
```
------------

>mvn -Dtest=LoginTest test
```sh
[INFO] Running tests.LoginTest
...
[INFO] Tests run: 3, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 10.236 s - in tests.LoginTest
```
>mvn -Dtest=LoginTest#wrongPassword test
```sh
[INFO] Running tests.LoginTest
...
======================================== STARTING TEST wrongPassword ========================================
======================================== FINISHED TEST wrongPassword Duration: 1s ========================================
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 3.977 s - in tests.LoginTest
```
>mvn -Dtest=LoginTest#correctCredentials+emptyUsernameAndPassword test
```sh
[INFO] Running tests.LoginTest
...
======================================== STARTING TEST correctCredentials ========================================
======================================== FINISHED TEST correctCredentials Duration: 1s ========================================
======================================== STARTING TEST emptyUsernameAndPassword ========================================
======================================== FINISHED TEST emptyUsernameAndPassword Duration: 1s ========================================
[INFO] Tests run: 2, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 7.287 s - in tests.LoginTest
```
>mvn clean test -DsuiteXmlFile=src/test/resources/regression.xml
------------
>mvn clean test -Dbrowser=chrome




## **SAUCEDEMO.COM Checklist**

- Проверить поле Логина	`Login` 
- Проверить поле Пароля	`Login`
- Проверить валидацию логина и пароля	`Login`
- Проверить страницу Продуктов (лого, линки, отображение)	`Product Page`
- Проверить сортировку продуктов	`Product Page`
- Проверить добавление в корзину	`Product Page`
- Проверить удаление из корзины	`Product Page`
- Проверить переходы по боковой панели (All items, about)	`Product Page`
- Проверить переходы в корзину по иконке корзины 	`Product Page`
- Проверить страницу Корзина `Cart Page`
- Проверить переход на страницу продуктов по кнопке	`Cart Page`
- Проверить удаление из корзины на странице по кнопке	`Cart Page`
- Проверить валидность отображаемой информации о товаре (наименование, стоимость)  	`Cart Page`
- Проверить поле Имя	`Checkout Page`
- Проверить поле Фамилия	`Checkout Page`
- Проверить поле Почтового индекса	`Checkout Page`
- Проверить переход на страницу Корзины по кнопке 	`Checkout Page`
- Проверить переход на Второй этап Checkout по кнопке 	`Checkout Page`
- Проверить валидацию личных данных в форме	    `Checkout Page`
- Проверить отображение страницы 2-ого этапа Checkout	`2-nd step Checkout Page`
- Проверить валидность отображаемой информации о товаре (наименование, стоимость)  	`2-nd step Checkout Page`
- Проверить преход на список продуктов по кнопке	`2-nd step Checkout Page`
- Проверить отображение информации об оплате и доставке	`2-nd step Checkout Page`
- Проверить переход на станицу завершения заказа 	`2-nd step Checkout Page`
- Проверить отображение страницы завершения заказа 	`Complete Page`
- Проверка выхода из учётной записи	`Side Bar`

