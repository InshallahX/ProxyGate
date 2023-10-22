# ProxyGate

**ProxyGate** is a BungeeCord plugin designed to manage a whitelist for your BungeeCord proxy server. It allows you to control who can connect to your server by maintaining a list of whitelisted players.

## Features

- **Whitelist Management:** Maintain a list of whitelisted players to control server access.
- **Event Listener:** Monitors player connections to enforce whitelist rules.

## Installation

1. Download the latest release of **ProxyGate** from the [Releases](https://github.com/InshallahX/ProxyGate/releases) page.
2. Place the downloaded JAR file into the "plugins" folder of your BungeeCord server.
3. Start or restart your BungeeCord server.

## Commands

- `/whitelist add <player>`: Add a player to the whitelist.
- `/whitelist remove <player>`: Remove a player from the whitelist.
- `/whitelist list`: List all whitelisted players.

## Permissions

- `proxigate.whitelist`: Permission to use the `/whitelist` command.

## Usage

1. Add players to the whitelist using the `/whitelist add <player>` command.
2. Remove players from the whitelist using the `/whitelist remove <player>` command.
3. Players on the whitelist can now connect to your BungeeCord server.

## Customization

You can customize the greeting and farewell messages in the `config.yml` file located in the plugin data folder.

## Building from Source

If you want to build **ProxyGate** from source, you can clone the repository and use a Java development environment to compile the code.

## License

This project is licensed under the [MIT License](LICENSE).
