# API DOCS

## Implemented handlers:

#### get("/horses/info/{id}")
Returns:
* code 200 + Horses structs JSON
* code 500

#### get("/users/about/{login}")
Returns:
* code 404 if user with such login is not found
* code 500
* 403 if profile is private
* 200 + JSON with one of the following:
```
"UserType": res.UserType,
"Credits": res.Credits,
"Balance": res.Balance,
"About": res.AssocInf,
```
in case of fully public profile or following:
```
"UserType": res.UserType,
"About": res.AssocInf,
```
in case of semi-public profile

#### get("/users/login")
Takes: `UserLoginPayload` Json

Returns:
* code 200 + json with only field `id` which is set to users id.
* code 500 in case of server failure.
* code 403 in case of invalid login data.

#### get("/run/about/{id}")
Returns:
* 404
* 500
* 200 + `Run` JSON

#### post("/run/register")
Takes: `RunRegisterPayload` JSON

Returns:
* 404 if user credits was incorrect
* 403 in case of lack of privileges
* 500
* 200 with no body

#### post("/bet/make")
Takes: `BetMakePayload`

Returns:
* 403 in case where user have no money
* 500
* 200 with no body

#### get("/bet/of/{id_usr}/")
Returns:
* 200 + JSON with list of integer bet numbers
* 404

#### get("/bet/about/{id}")
Returns:
* 200 + JSON with optional `Bet` structure

#### get("/run/pending")
Returns:
* 200 + JSON with array of `Run` objects

#### get("/run/pending/of/{id}")
Returns:
* 200 + JSON with array of `Run` objects


## Data structures json:

```
	pub struct Horses {
		pub ID: i32,
		pub Name: Option<String>,
		pub Owner: Option<i32>,
		pub Age: Option<i32>,
		pub WinRate: Option<f64>,
		pub RunsDone: i32, //Skoko zabegov begala
	}
```

```
	pub struct UserLoginPayload {
		pub login: String,
		pub passwh: Vec<u8>,
	}
```

```
	pub struct RunRegisterPayload {
		pub login: String,
		pub passwh: Vec<u8>,
		pub date: chrono::NaiveDate,
		pub place: String,
		pub winner: i32,
		pub competitors: Vec<i32>,
	}
```

```
	pub struct BetMakePayload {
		pub login: String,
		pub passwh: Vec<u8>,
		pub on_id_run: i32,
		pub money: f64,
		pub on_id_horse: i32,
	}
```

```
	pub struct Run {
		pub ID: i32,
		pub Date: Option<chrono::NaiveDate>,
		pub Place: Option<String>,
		pub Winner: Option<i32>, //Loshad chto pobedila
		pub CompetLFK: Option<i32>
	}
```

```
	pub struct Bet {
		pub ID: i32,
		pub Who: Option<i32>, // Kto?
		pub Value: Option<f64>, // Skoko?
		pub on_run: Option<i32>, //
		pub on_winner: Option<i32>,
		pub win_rate: Option<f64>,
	}
```

## Links
https://docs.rs/chrono/0.4.0/chrono/naive/struct.NaiveDate.html
