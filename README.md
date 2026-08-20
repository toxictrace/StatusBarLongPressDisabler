# StatusBar LongPress Disabler (LSPosed)

Модуль отключает long-press на статус-баре SystemUI через хук:

```
NotificationPanelViewController#onStatusBarLongPress(MotionEvent) -> returnConstant(null)
```

## Установка проекта в Termux

```bash
cd ~
git clone <твой репозиторий>
cd StatusBarLongPressDisabler
```

(или создай новый репозиторий на GitHub и запушь эту папку целиком)

## Secrets в GitHub (Settings → Secrets and variables → Actions)

- `KEYSTORE_BASE64` — keystore.jks, закодированный: `base64 -w0 your.jks`
- `KEYSTORE_PASSWORD`
- `KEY_ALIAS`
- `KEY_PASSWORD`

## Релиз

```bash
git tag v1.0
git push origin v1.0
```

Workflow соберёт `app-release.apk` и прикрепит к GitHub Release.

## Активация

1. Установи APK на устройство с LSPosed.
2. Открой LSPosed Manager → включи модуль "StatusBar LongPress Disabler".
3. В области действия (scope) отметь `com.android.systemui`.
4. Перезапусти System UI (или перезагрузи устройство).

## Примечание

Имя класса `NotificationPanelViewController` и метод `onStatusBarLongPress`
специфичны для конкретной версии/сборки SystemUI (AOSP-based). Если после
установки в логах LSPosed видна ошибка `NoSuchMethodError`/`ClassNotFoundError`,
значит в твоей прошивке класс/метод называется иначе — тогда нужно
декомпилировать `SystemUI.apk` с целевого устройства и уточнить сигнатуру.
