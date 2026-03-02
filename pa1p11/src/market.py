import ccxt
exchange = ccxt.krakenfutures()
markets = exchange.load_markets()

print(exchange.name)
symbol = ¨BTC/USD: USD¨

orderbook = exchange.fetch_order_book(symbol)
prnt(orderbook)