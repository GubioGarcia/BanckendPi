// game_provider.dart
import 'custom_change_notifier.dart';
import 'game_model.dart';

class GameProvider extends CustomChangeNotifier {
  final List<Game> _myGames = [
    Game(
      id: '1',
      title: 'The Witcher 3: Wild Hunt',
      developer: 'CD Projekt Red',
      publisher: 'CD Projekt',
      price: 79.90,
      rating: 4.9,
      coverUrl:
          'https://images.igdb.com/igdb/image/upload/t_cover_big/co2rry.jpg',
      description: 'RPG de mundo aberto em um universo de fantasia sombria.',
      category: 'RPG',
      platforms: ['PC', 'PlayStation', 'Xbox', 'Switch'],
      releaseYear: 2015,
      isCompleted: false,
      completionDate: null,
      playtime: 0,
      platform: 'PC',
      isInLibrary: true,
    ),
    Game(
      id: '7',
      title: 'Stardew Valley',
      developer: 'ConcernedApe',
      publisher: 'ConcernedApe',
      price: 24.90,
      rating: 4.9,
      coverUrl:
          'https://images.igdb.com/igdb/image/upload/t_cover_big/co2rrd.jpg',
      description: 'Simulação de fazenda e vida rural.',
      category: 'Simulação',
      platforms: ['PC', 'PlayStation', 'Xbox', 'Switch', 'Mobile'],
      releaseYear: 2016,
      isCompleted: false,
      completionDate: null,
      playtime: 0,
      platform: 'Switch',
      isInLibrary: true,
    ),
  ];

  List<Game> get myGames => _myGames;

  void addToLibrary(Game game) {
    if (!_myGames.any((g) => g.id == game.id)) {
      _myGames.add(game.copyWith(isInLibrary: true));
      notifyListeners();
    }
  }

  void removeFromLibrary(String gameId) {
    _myGames.removeWhere((game) => game.id == gameId);
    notifyListeners();
  }

  bool isInLibrary(String gameId) {
    return _myGames.any((game) => game.id == gameId);
  }

  void toggleLibraryStatus(Game game) {
    if (isInLibrary(game.id)) {
      removeFromLibrary(game.id);
    } else {
      addToLibrary(game);
    }
  }

  void updateGamePlaytime(String gameId, int hours) {}
}
