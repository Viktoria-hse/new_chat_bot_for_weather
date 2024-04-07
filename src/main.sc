require: slotfilling/slotFilling.sc
  module = sys.zb-common
theme: /Weatherandexchage

    state: Start
        q!: *start
        q!: *(привет/здравствуй*/~добрый (~утро/~вечер/~ночь)/~hello)*
        a: Привет! Я чат-бот, который может рассказать вам о погоде и курсе валют.Задайте свой вопрос, чтобы я мог помочь вам!

    state: Weather
        intent!: /weather 
        a: Уточните место с интересующей вас погодой и даттой.
        state: Weather
            q!: Вы хотите узнать о погоде в каком городе?
        state: Weather2
            q!: *~weather**
            a: Вы хотите узнать о погоде в каком городе?
        state: Weather3
            q!: *(погода/градусов*/~сколько (~градусов/~температура/~цельсий)/~в)*
            a: Погода в Москве 15 градусов.
            
    state: Currency
        intent!: /currency
        a: Уточните место с интересующей вас погодой и даттой.
        state: Currency
            q!: *~валют~**
            a: Назовите день и валюты для расчета。
        state: Currency2
            q!: *~курс**
            a: Курс валюты на сегодня 89 руб
            
        
    state: Bye
        intent!: /пока
        a: Пока пока

    state: NoMatch
        event!: noMatch
        a: Я не понял. Вы сказали: {{$request.query}}

    state: Match
        event!: match
        a: {{$context.intent.answer}}