<template>
  <v-app>
    <v-app-bar
      app
      color="teal darken-1"

    >
      <div class="d-flex align-center">
        <v-card
          class="xs-auto"
          href = "/"
          max-width="150"
          flat
        >
        </v-card>
      </div>

      <v-spacer></v-spacer>

    <v-menu offset-y>
      <v-list>
        <v-list-item-group
          v-model="model"
          color="primary"        
        >
        </v-list-item-group>
      </v-list>
    </v-menu>
    </v-app-bar>
    <v-main>
      <v-container>
      <router-view></router-view>
      </v-container>
    </v-main>
  </v-app>
</template>

<script>

export default {
  name: 'App'
};
</script>
