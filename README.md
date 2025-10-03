# Twasol — تطبيق مراسلة فورية

[![Flutter CI](https://github.com/Almefta/twasol/actions/workflows/flutter-ci.yml/badge.svg?branch=feature/clean-initial)](https://github.com/Almefta/twasol/actions/workflows/flutter-ci.yml)

تطبيق مراسلة فورية مبني بـ **Flutter** يركّز على السرعة والبساطة وقابلية التوسّع. يوفّر إرسال/استقبال الرسائل الفورية، الإشعارات، وإدارة الجلسات مع فصلٍ صارمٍ للأسرار وإعداد **CI** لضمان جودة البناء بشكل مستمر.

---

## المزايا
- 💬 محادثات فورية (نصوص) مع بنية قابلة لإضافة ملفات/صور لاحقًا.
- 🔔 إشعارات دفع (FCM) مع دعم foreground/background.
- 👤 إدارة جلسات/مستخدمين (قابلة للتبديل حسب مزود المصادقة).
- 🧹 جودة الكود: `flutter_lints` + `flutter analyze`.
- ⚙️ تكامل مستمر (CI) عبر GitHub Actions: تحليل + (اختبارات إن وُجدت) + بناء APK Debug.
- 🧩 بنية منظمة وسهلة التطوير وإضافة الميزات.

> يوجد أداة فحص للإشعارات: `lib/debug/fcm_healthcheck.dart` للحصول على تقرير سريع عن الصلاحيات والـtoken.

---

## المتطلبات
- Flutter (قناة **stable**)  
- Android SDK + **Java 17**  
- (اختياري) Xcode & CocoaPods لـ iOS

تحقّق سريع:
```bash
flutter --version
flutter doctor -v
