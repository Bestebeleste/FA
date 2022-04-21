import * as React from 'react';
import { List } from 'react-native-paper';
import { Searchbar } from 'react-native-paper';
import { Avatar } from 'react-native-elements';
import { Divider } from 'react-native-elements';
import { Text, View, Image, StyleSheet, Button, Alert, ScrollView } from 'react-native';
import { useNavigation } from '@react-navigation/native';


export default function HomeScreen() {
  const navigation = useNavigation();

  function toProfile(i) {
        navigation.navigate("Контакт " + i);
  }
  function toMyProfile() {
        navigation.navigate("Мой профиль")
  }
  return(<ScrollView>
    <List.Item
    title="Бульк"
    titleStyle={{ fontWeight: 'bold' }}
    description="Мой профиль"
    onPress={() => toMyProfile()}
    left={props => <Avatar rounded size={140} source={require('../first.jpg')} />}
    />
    <Divider orientation="horizontal" />
    <List.Item
    title="Бады"
    bottomDivider
    titleStyle={{ fontWeight: 'bold' }}
    onPress= {() => toProfile("1")}
    left={props => <Avatar rounded size={80} source={require('../second.jpg')} />}
    />
    <Divider orientation="horizontal" />
    <List.Item
    title="Бойду"
    titleStyle={{ fontWeight: 'bold' }}
    onPress= {() => toProfile("2")}
    left={props => <Avatar rounded size={80} source={require('../third.jpg')} />}
    />
    <Divider orientation="horizontal" />
    <List.Item
    title="Батыр"
    bottomDivider
    titleStyle={{ fontWeight: 'bold' }}
    onPress= {() => toProfile("3")}
    left={props => <Avatar rounded size={80} source={require('../fourth.jpg')} />}
    />
    <Divider orientation="horizontal" />
    <List.Item
    title="Тинмей"
    bottomDivider
    titleStyle={{ fontWeight: 'bold' }}
    onPress= {() => toProfile("4")}
    left={props => <Avatar rounded size={80} source={require('../fifth.jpg')} />}
    />
    <Divider orientation="horizontal" />
    <List.Item
    title="Чаян"
    titleStyle={{ fontWeight: 'bold' }}
    onPress= {() => toProfile("5")}
    left={props => <Avatar rounded size={80} source={require('../sixth.jpg')} />}
    bottomDivider
    />
    <Divider orientation="horizontal" />
    <List.Item
    title="Антон"
    titleStyle={{ fontWeight: 'bold' }}
    onPress= {() => toProfile("6")}
    left={props => <Avatar rounded size={80} source={require('../seventh.jpg')} />}
    />
  </ScrollView>);
}

