# Cocktail_Bar
## Реализованная функциональность
Полностью реализован domain и data слой приложения. Реализован функционал экрана со списком коктейлей. С него можно перейти на экран создания коктейля. На экране создания реализовано все за исключением диалога с добавлением ингредиента (диалог не возвращает результат). Создать коктейль на данном этапе невозможно. На экране деталей частично реализован макет, логика работы экрана не реализована, перейти на него нельзя.
### Скриншоты:
<img src="https://github.com/H3llW1z/Cocktail_Bar/assets/99041389/6e144ecf-7fc8-4d57-b45c-732d051c03c1" width=20% height=20% />
<img src="https://github.com/H3llW1z/Cocktail_Bar/assets/99041389/fc43d543-6c55-4109-b433-bd529cb933e0" width=20% height=20% /> 
<img src="https://github.com/H3llW1z/Cocktail_Bar/assets/99041389/b08091c8-6b69-44f3-8d12-a5f98dc3c3cc" width=20% height=20% />  
<img src="https://github.com/H3llW1z/Cocktail_Bar/assets/99041389/6f98fe9b-09d1-4401-abde-e4aadde0407b" width=20% height=20% />
<img src="https://github.com/H3llW1z/Cocktail_Bar/assets/99041389/305d1a9b-211f-41eb-8acf-ed3c7da2b579" width=20% height=20% />

### Гифка с работой приложения:
<img src="https://github.com/H3llW1z/Cocktail_Bar/assets/99041389/185c8f19-2a68-42c4-bdb5-b6931163ed2c" width="300">

## Технические детали реализации
Для локального хранения используется библиотека Room, для инъекции зависимостей используется Dagger.
## Используемые технологии и архитектура
Приложение построено по принципу Clean Architecture с использованием инъекции зависимостей. В presentation-слое используется паттерн MVVM с элементом MVI в виде класса состояния экрана. Использованы элементы UDF.
